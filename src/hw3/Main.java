package hw3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        list.addAll(0, Arrays.asList(
                "Banana",
                "Potato",
                "Orange",
                "Banana",
                "FLat",
                "Sun",
                "Level",
                "Sun",
                "Phone",
                "Book",
                "Potato"
        ));
        System.out.println("--Task 1--");
        System.out.println(list);
        //список уникальных слов
        set.addAll(list);
        System.out.println(set);
        for (int i = 0; i < list.size(); i++) {
            Integer val = map.getOrDefault(list.get(i), 0);
            map.put(list.get(i), val + 1);
        }
        System.out.println(map);

        TelephoneDirectory td = new TelephoneDirectory();

        td.add("Petrov", "123");
        td.add("Petrov", "456");
        td.add("Petrov", "456");
        td.add("Ivanov", "789");
        td.add("Ivanov", "741");
        td.add("Shapochkin", "852");
        td.add("Bublikov", "963");

        System.out.println("--Task 2--");
        System.out.println(td.get("Shapochkin"));

    }
}
