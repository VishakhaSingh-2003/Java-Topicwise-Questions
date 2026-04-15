
package hashmap;
import java.util.*;
import java.util.TreeMap;

public class Treehm {
    public static void main(String[] args) {
        TreeMap<String, Integer> thm = new TreeMap<>();
        thm.put("India", 100);
        thm.put("China", 150);
        thm.put("US", 50);
        thm.put("Australia", 170);
        System.out.println(thm);
    }
}
