package hw5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        massive1();
        massive2();
    }

    public static void massive1(){
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        long timeBegin;

        fill(arr);

        timeBegin = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        System.out.println("Time 1: " + (System.currentTimeMillis() - timeBegin) +
                " arr[h + 1] " + arr[h + 1] +
                " arr[h + 2] " + arr[h + 2] +
                " arr[h + 3] " + arr[h + 3]
        );
    }

    public static void massive2(){
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        long timeBegin;

        fill(arr);

        timeBegin = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        MyThread th1 = new MyThread(arr1,0);
        MyThread th2 = new MyThread(arr2, h);

        th1.run();
        th2.run();

        try{
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);

        System.out.println("Time 2: " +
                (System.currentTimeMillis() - timeBegin) +
                " arr[h + 1] " + arr[h + 1] +
                " arr[h + 2] " + arr[h + 2] +
                " arr[h + 3] " + arr[h + 3]
                );
    }

    public static void fill(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
    }

}
