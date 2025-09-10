public class secondLargest {
    public static int secLarge(int[] arr){
        int large = Integer.MIN_VALUE;
         int secondLarge = Integer.MIN_VALUE;
         for(int i=0; i<arr.length; i++){
            if(arr[i]>large){
                large = arr[i];
            }
         }
         for(int i=0; i<arr.length; i++){
            if(arr[i]<large && arr[i]>secondLarge){
                secondLarge=arr[i];
            }
         }
         return secondLarge;
    }
    public static void main(String[] args) {
        int[] arr = {3,5,7,9,10};
        System.out.println("Second largest is: "+secLarge(arr));
    }
}
