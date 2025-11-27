import java.util.*;
public class moveZeros {
    public static void moveZero(int[] nums ){
        int n = nums.length;
        int i = 0;
        for(int j=0; j<n; j++){
            if(nums[j]!=0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZero(nums);
        System.out.println(Arrays.toString(nums));

    }
}
