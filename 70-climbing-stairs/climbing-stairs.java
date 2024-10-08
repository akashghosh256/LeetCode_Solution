class Solution {

    // same as fibonacci series
        // static int f(int n , int dp[]){
        //     if(n<=1) return 1;

        //     if( dp[n] != -1) return dp[n];

        //     return dp[n]= f(n-1,dp)+f(n-2,dp);
        
        // }

    public int climbStairs(int n) {
        
        // int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);
        // dp[0] =1;
        // dp[1]=1;
        // for(int i=2;i<=n;i++){
        //     dp[i] = dp[i-1]+dp[i-2];
        // }
        // // return (f(n,dp));
        // return dp[n];

        int prev = 1;
        int prev2 = 1;
        // Running for loop to count all possible ways
        for (int i = 2; i <= n; i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;

    }
}