public class missingNumber {
    public static int missingNum(int[] nums){
     int missing = nums.length;
     for(int i=0; i<nums.length; i++){
        missing = missing^i^nums[i];
     }
     return missing;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,3};
        System.out.println(missingNum(nums));
    }
}
