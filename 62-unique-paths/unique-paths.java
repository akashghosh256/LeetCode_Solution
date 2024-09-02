class Solution {

    int helper(int i, int j, int m, int n, int dp[][]){
        if( i== m-1 && j == n-1) return 1;
        if( i>=m || j>=n) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = helper(i+1,j,m,n,dp) + helper(i,j+1,m,n,dp);


    }


    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int[] i : dp)
        Arrays.fill(i,-1);
        int  ways =  helper(0,0,m,n,dp);
        if(m == 1 && n ==1) return ways;
        return dp[0][0];


    }
}