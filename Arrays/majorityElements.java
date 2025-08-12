import java.util.*;
public class majorityElements {
    public static int majorityElts(int arr[]){
        int majorityElements = arr.length/2;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>majorityElements){
                return arr[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of aray");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter array elements");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();

        }
        System.out.println("Answer is: "+majorityElts(arr));
    }
}
