import java.util.Arrays;
public class missingAndDuplicateElement {
    public static int[] findRepeatingAndMissing(int[][] grid){
        int n = grid.length;
        int total = n*n;
        int[] ans = new int[2];
        for(int num=1; num<=total; num++){
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==num){
                    count++;
                }
            }
        }
        if(count>1){
            ans[0] = num;
        }
        else if(count==0){
            ans[1] = num;
        }
        }
        return ans;
        
    }
    public static void main(String[] args) {
       int[][] grid = {
            {1, 3},
            {2, 2}
        };
        int[] result =findRepeatingAndMissing(grid);
        System.out.println(Arrays.toString(result));

    }
}
