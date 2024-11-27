package graph;

public class LCSRC {
    public static void main(String[] args){

    }
    public static int lcsrc(String s1,String s2,int i ,int j, int[][]dp){
        if(i==s1.length() || j==s2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=1+lcsrc(s1,s2,i+1,j+1,dp);
        }
        else{
            int fs=lcsrc(s1,s2,i+1,j,dp);
            int ss=lcsrc(s1,s2,i,j+1,dp);
            ans=Math.max(ans,fs);
        }
        return dp[i][j]=ans;
    }
}
