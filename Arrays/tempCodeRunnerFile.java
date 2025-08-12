public class majorityElements {
    public static int majorityElts(int arr[]){
        int majorityElements = arr.length/2;
       
        for(int i=0; i<arr.length; i++){
            int count = 0;
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