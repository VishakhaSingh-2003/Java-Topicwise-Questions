package Recursion;
public class xPowerN {
    public static int optimizedPow(int a, int n){

        if(n==0){
            return 1;
        }
       int halfPow = optimizedPow(a, n/2);
       int halfPowerSq = halfPow*halfPow;
       if(n%2!=0){
         halfPowerSq = a * halfPowerSq;
       }
           return halfPowerSq;
    }
    public static void main(String[] args) {
        int a = 2;
        int n = 10;
        System.out.println(optimizedPow(a, n));
    }
}
