import java.util.*;

public class maxSubArray {
    public static int maxSubarray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (currSum > maxSum) {
                maxSum = currSum;
            }

            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = maxSubarray(nums);
        System.out.println("Maximum Subarray Sum: " + result);
    }
}