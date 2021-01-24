package hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    static final int PORT = 10002;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        DataInputStream in;
        DataOutputStream out;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");
            socket = server.accept();
            System.out.println("Client connected");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);

            Thread tR = new Thread(() -> {
                try {
                    while (true){
                        String s = in.readUTF();
                        if (s.equals("/end")){
                            System.out.println("Client is disconnected");
                            out.writeUTF("/end");
                            break;
                        } else {
                            System.out.println("Client: " + s);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            Thread tW = new Thread(() -> {
                try{
                    while (true){
                        out.writeUTF(sc.nextLine());
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
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
