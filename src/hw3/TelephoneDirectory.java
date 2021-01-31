package hw3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TelephoneDirectory {

    private HashMap<String, Set<String>> map = new HashMap<>();

    public void add(String name, String number){
        Set<String> set = map.getOrDefault(name, new HashSet<>());
        set.add(number);
        map.put(name, set);
    }

    public Set<String> get(String name){
        return map.get(name);
    }

    public HashMap<String, Set<String>> getMap() {
        return map;
    }

}
