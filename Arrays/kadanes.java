public class kadanes {

    public static int kadanesAlgo(int [] arr){
        int cs = 0;
        int ms = 0;
        for(int i=0; i<arr.length; i++){
            // cs = cs+arr[i];
            // if(cs<0){
            //     cs=0;
            // }
            cs = Math.max(arr[i], cs+arr[i]);
            ms = Math.max(ms, cs);
        }
        return ms;
    }
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(kadanesAlgo(arr));
    }
    
}
