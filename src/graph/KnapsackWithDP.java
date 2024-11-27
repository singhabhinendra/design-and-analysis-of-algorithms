package graph;
import java.util.ArrayList;
import java.util.Arrays;
public class KnapsackWithDP {
    public static void main(String[] args){
        int[] wt={1,2,3,2,2};
        int[] val={8,4,0,5,3};
        int cap=4;
        int[][] dp=new int[wt[cap]+1][val[cap]+1];

        for(int [] a:dp){
            Arrays.fill(a,-1);
        }
        System.out.print(MaxRec(0,cap,wt,val,dp));
    }
    private static int MaxRec(int i, int cap, int[] wt, int[] val, int[][] dp){
        if(i>=wt.length){
            return 0;
        }

        if(dp[cap][i]!=-1){
            return dp[cap][i];
        }
        int a=0;
        if(cap>=wt[i]){
            a=a+MaxRec(i+1,cap-wt[i],wt,val,dp);
        }
        int b=MaxRec(i+1,cap,wt,val,dp);
        return dp[cap][i];
    }
}
