import java.util.*;
public class distinctElementCount {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,4,2,1,6,7};
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        System.out.println(set);
        System.out.println(set.size());

    }
}
