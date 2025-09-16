package hashmap;
import java.util.*;
public class operations {
    public static void main(String[] args) {
    //create
     HashMap<String, Integer> hm = new HashMap<>();

     //insert - o(1)
     hm.put( "India",  100);
     hm.put( "America",  150);
     hm.put( "London",  200);
     System.out.println(hm);

     //get - o(1)
     int population = hm.get("India");
     System.out.println(population);
      System.out.println(hm.get("Indonesia"));

     //containsKey - o(1)
     System.out.println(hm.containsKey("India"));
     System.out.println(hm.containsKey("Indonesia"));

     //remove - o(1)
     System.out.println(hm.remove("London"));
     System.out.println(hm);
      
     //size
     System.out.println(hm.size());

     //isEmpty
     System.out.println(hm.isEmpty());

     //clear
     //hm.clear();
    }
}
