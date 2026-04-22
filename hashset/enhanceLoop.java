import java.util.HashSet;

public class enhanceLoop {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("delhi");
        cities.add("mumbai");
        cities.add("nagpur");
        cities.add("noida");

        for(String city: cities){
            System.out.println(city);
        }
        
    }
}
