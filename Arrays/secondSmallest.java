public class secondSmallest {
    public static int secondSmallest(int arr[]){
        int smallest = Integer.MAX_VALUE;
        int secSmallest = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<smallest){
                smallest = arr[i];
            }
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]>smallest && arr[i]<secSmallest){
                secSmallest=arr[i];
            }
        }
        return secSmallest;

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(secondSmallest(arr));
    }
    
}
