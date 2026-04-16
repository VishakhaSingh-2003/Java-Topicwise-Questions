
import java.util.*;
public class operations {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(2);

        System.out.println(set);

        if(set.contains(2)){
        System.out.println("set contains 2");
        }
        if(set.contains(4)){
        System.out.println("set contains 4");
        }

        set.remove(1);
        System.out.println(set);
        set.clear();
        System.out.println(set.size());
        System.out.println(set.isEmpty());
    }
    
}
