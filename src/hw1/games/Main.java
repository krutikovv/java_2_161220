package hw1.games;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int tempNumber;
        int numHurdles = 3; //Число препятсвий

        RunningTrack runningTrack = new RunningTrack();
        Wall wall = new Wall();

        runningTrack.setLength(8);
        wall.setHeigth(3);


        RunningTrack[] runningTracks = new RunningTrack[numHurdles];
        Wall[] walls = new Wall[numHurdles];

        //Создаем препятствия с рандомными величинами
        //+ Для удобства вывод в консоль этих велчин
        for (int i = 0; i < numHurdles; i++) {
            tempNumber = random.nextInt(20) + 1;
            System.out.printf( "Препятствие " + (i + 1) + " Бег: " + "%-3d", tempNumber);

            runningTracks[i] = new RunningTrack();
            runningTracks[i].setLength(tempNumber);

            tempNumber = random.nextInt(20) + 1;
            System.out.print(" Прыжок: " + tempNumber + "\n");

            walls[i] = new Wall();
            walls[i].setHeigth(tempNumber);
        }
        System.out.println("--------------------------------");

        Advancedable[] massive = {
                new Cat(new StringBuilder("Кот Иван"), 15 , 10),
                new Human(new StringBuilder("Человечешко Адам"), 10, 9),
                new Robot(new StringBuilder("Робот R2D2"), 20, 15)
        };

        for (int i = 0; i < numHurdles; i++) {
            for (int j = 0; j < 3; j++) {
                massive[j].overcome(runningTracks[i], walls[i]);
            }
            System.out.println("--------------------------------");
        }

    }
}

