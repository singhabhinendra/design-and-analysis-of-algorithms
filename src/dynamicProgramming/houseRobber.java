package dynamicProgramming;

import java.util.Arrays;

public class houseRobber {
        public int rob(int[] nums) {
            if(nums.length==1)return nums[0];
            if(nums.length==2) return Math.max(nums[0],nums[1]);
            int[] dp=new int [nums.length];
            Arrays.fill(dp,-1);
            return find(0,nums,dp);

        }
        public int find(int i,int nums[],int dp[]){
            if(i>=nums.length){
                return 0;
            }
            if(dp[i]!=-1){
                return dp[i];
            }
            int rob=nums[i]+find(i+2,nums,dp);
            int drob=find(i+1,nums,dp);
            dp[i]=Math.max(rob,drob);
            return dp[i];
        }
    public static void main(String[] args) {
            houseRobber ho=new houseRobber();
            System.out.println(ho.rob(new int[]{1,2,3,1}));
    }
}
