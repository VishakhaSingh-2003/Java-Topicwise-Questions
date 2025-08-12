import java.util.Arrays;
public class mergeTwoSortedArrays {
    public static void merge(int[] arr1, int m, int[] arr2, int n){
        int idx = m+n-1;
        int i = m-1;
        int j = n-1;
        while(i>=0 && j>=0){
            if(arr1[i]<=arr2[j]){
                arr1[idx]=arr2[j];
               idx--;
               j--;
            }
            else{
                arr1[idx]=arr1[i];
                idx--;
                i--;
            }

        }
        while(j>=0){
            arr1[idx]=arr2[j];
               idx--;
               j--;
        }
    }
    public static void main(String[] args) {
       int arr1[] = {1,2,3,0,0,0};
        int arr2[] = {2,5,6};
        merge(arr1, 3, arr2, 3);
        System.out.println(Arrays.toString((arr1)));
    }
}
