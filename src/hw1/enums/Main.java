package hw1.enums;

public class Main {
    public static void main(String[] args) {
        Planet planet = Planet.Mars;
//        Planet planet2 = Planet.Earth;
//        System.out.println(planet==planet2);
//        System.out.println(planet.compareTo(planet2));
//        System.out.println(planet.ordinal());
        for (Planet p : Planet.values()) {
            System.out.println(p+" "+p.getSize() );
        }

//        switch (planet){
//            case Mercury:
//            case Mars:
//        }
    }
}
