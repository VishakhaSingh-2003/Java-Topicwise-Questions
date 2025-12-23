public class largestElement {
    public static int larElt(int[] arr){
        int n = arr.length;
        int lar = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(arr[i]>lar){
                lar = arr[i];
            }
        }
        return lar;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,5,8,4,6};
        System.out.println("largest elemnt is: " + larElt(arr));
    }
    
}
