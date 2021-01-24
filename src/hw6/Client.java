package hw6;

import javax.swing.plaf.TableHeaderUI;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_NAME = "localhost";
    private static final int SERVER_PORT = 10002;

    public static void main(String[] args) {
        Socket socket = null;
        DataInputStream in;
        DataOutputStream out;
        Scanner scanner;
        try {
            socket = new Socket(SERVER_NAME, SERVER_PORT);
            System.out.println("Client started");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);

            Thread tR = new Thread(() -> {
                try {
                    while (true){
                        String s = in.readUTF();
                        if (s.equals("/end")){
                            System.out.println("The connection with server is lost");
                            out.writeUTF("/end");
                            break;
                        } else {
                            System.out.println("Server: " + s);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            Thread tW = new Thread(() -> {
                try{
                    while (true){
                        out.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            tW.setDaemon(true);
            tW.start();
            tR.start();
            tR.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
