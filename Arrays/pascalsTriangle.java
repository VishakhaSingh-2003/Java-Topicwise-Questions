import java.util.*;
public class pascalsTriangle {

  public static void pascalTriangle(int n){
    int ans[][] = new int[n][n];

       for(int i=0; i<n; i++){
           for(int j=0; j<=i; j++){
               if(j==0 || i==j){
                    ans[i][j] =1 ;
                }
              else{
                    ans[i][j] = ans[i-1][j]+ans[i-1][j-1];
                } System.out.print(ans[i][j]+" ");
           }
            System.out.println();
       }
       
   }
   public static void main(String[] args) {
      int n=5;
        pascalTriangle(n);
   }
}




 
