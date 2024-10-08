class Solution {

    private int helper(int ind, int nums[],int dp[]){
        if(ind == 0) return nums[ind];
        // 1 - 2 = -1 
        if( ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];

        int pick = nums[ind] + helper(ind-2, nums,dp);
        int notPick = 0 + helper(ind-1, nums, dp);

        return dp[ind] = Math.max(pick, notPick);

    }


    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
         return helper(n-1,nums,dp);

    }
}