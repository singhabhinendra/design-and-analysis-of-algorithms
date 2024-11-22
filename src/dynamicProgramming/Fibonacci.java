package dynamicProgramming;
import java.util.Arrays;
public class Fibonacci {
    public static void main(String[] args){
        int n=5;
        System.out.println(fibbRC(n));
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibbTD(n,dp));
        System.out.println(fibbBU(n,dp));
    }
    private static int fibbRC(int n ){
        if(n==0||n==1){
            return n;
        }
        int a =fibbRC(n-1);
        int b =fibbRC(n-2);
        return a+b;
    }
    private static int fibbTD(int n,int[] dp){
        if(n==0||n==1){
            return n;
        }
//        use if already calculated
        if(dp[n]!=-1){
            return dp[n];
        }
//        calculate
        int a=fibbTD(n-1,dp);
        int b =fibbTD(n-2,dp);
//        store for future use
        dp[n]=a+b;
        return dp[n];
    }

    private static int fibbBU(int n,int[] dp){
        if(n==0||n==1){
            return n;
        }
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
