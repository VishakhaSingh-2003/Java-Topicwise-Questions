package hashmap;
import java.util.*;
public class iterationHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Indonesia", 200);
        hm.put("USA", 250);

        Set<String> keys = hm.keySet();
        System.out.println(keys);
        for (String k : keys) {
            System.out.println("key = "+ k +", value = " +hm.get(k));
            
        }

    }
    
}
