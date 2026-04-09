import java.util.*;
public class twoSum {
    public static int[] sum(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int sum = arr[left]+arr[right];
            if(sum == target){
                return new int[]{left, right};
            }
            if(sum>target){
                right--;
            }
            else{
                left++;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int arr[] = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(sum(arr, target)));
    }
}
