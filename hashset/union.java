import java.util.*;
public class union {

    public static void main(String[] args) {
        int arr1[] = {3,7,9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        HashSet<Integer> set = new HashSet<>();

        //union
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }
        System.out.println("size is: "+set.size());
        System.out.println("elements are: "+set);
    }
    
}
