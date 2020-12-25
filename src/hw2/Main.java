package hw2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //норм размер
        String[][] w1 = {
                {"0",  "1",  "2",  "3"},
                {"4",  "5",  "6",  "7"},
                {"8",  "9",  "10", "11"},
                {"12", "13", "14", "и"}
        };
        //больший размер (для теста)
        String[][] w2 = {
                {"0",  "1",  "2",  "3"},
                {"4",  "5",  "6",  "7"},
                {"8",  "9",  "10", "11"},
                {"12", "13", "14", "15"},
                {"16", "17", "18", "19"}
        };
        //меньший размер (для теста)
        String[][] w3 = {
                {"0",  "1",  "2",  "3"},
                {"4",  "5",  "6",  "7"},
                {"8",  "9",  "10", "11"}
        };

        try {
            getMassive(w1);
            System.out.println("Массив принят");
        } catch (MyArraySizeException e) {
            System.out.println(e);
        } catch (MyArrayDataException e){
            System.out.println(e);
        }
    }

    public static void getMassive(String[][] w) throws MyArraySizeException, MyArrayDataException{
        Integer[][] massive = new Integer[w.length][w.length];
        int iTemp = -1;
        int jTemp = -1;
        int sum = 0;
        //проверка на размерность
        if (w.length == 4) {
            for (int i = 0; i < w.length; i++) {
                if (w[i].length != 4){
                    throw new MyArraySizeException("Массив не 4х4!");
                }
            }
        } else {
            throw new MyArraySizeException("Массив не 4х4!");
        }
        //попытка конвертации и подсчета суммы
        try {
            for (int i = 0; i < w.length; i++) {
                for (int j = 0; j < w.length; j++) {
                    iTemp = i;
                    jTemp = j;
                    massive[i][j] = Integer.parseInt(w[i][j]);
                    sum += massive[i][j];
                    System.out.printf("%-3d", massive[i][j]);
                }
                System.out.println();
            }
            System.out.println("Сумма = " + sum);
        } catch (Exception e) {
            System.out.println("\nСумма = " + sum);
            System.out.printf("Неверные данныев ячейке: %-2d %-2d \n", iTemp, jTemp);
            throw new MyArrayDataException("Ошибка преобразования");
        }
    }

}
