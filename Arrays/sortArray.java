public class sortArray {
    public static boolean isSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5,6};
        int arr2[] = {2,1,0,5,6};
        System.out.println(isSort(arr1));
        System.out.println(isSort(arr2));
}
}
