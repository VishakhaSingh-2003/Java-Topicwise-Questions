public class singleElement {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count==1){
                return nums[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3, 4};
        singleElement obj = new singleElement();
        int result = obj.singleNumber(nums);
        System.out.println(result);
    }
}
    

