import java.util.*;
public class iterator {
    public static void main(String[] args) {
        HashSet cities = new HashSet<>();
        cities.add("delhi");
        cities.add("mumbai");
        cities.add("nagpur");
        cities.add("noida");
        Iterator itr = cities.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        

    }
}
