package graph;

public class KnapsackAlgorithm {
    public static void main(String[] args){
        int[] wt={1,2,3,2,2};
        int[] val={8,4,0,5,3};
        int cap=4;
        System.out.print(MaxRec(0,cap,wt,val));
    }
    private static int MaxRec(int i, int cap, int[] wt, int[] val){
        if(i>=wt.length){
            return 0;
        }
        int a=0;
        if(cap>=wt[i]){
            a=a+MaxRec(i+1,cap-wt[i],wt,val);
        }
        int b=MaxRec(i+1,cap,wt,val);
        return Math.max(a,b);
    }

}





