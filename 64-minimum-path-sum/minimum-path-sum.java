class Solution {

    int f(int i,int j, int a[][] ,int dp[][]){
        if( i<0 || j<0) return (int)Math.pow(10,9);
        if( i==0 && j==0) return a[0][0];
        if(dp[i][j] != -1) return dp[i][j];
        int up = a[i][j] + f(i-1,j,a,dp);
        int left = a[i][j] + f(i,j-1,a, dp);

        return dp[i][j] =  Math.min(up,left);


    }



    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int dp[][] = new int[row+1][col+1];
        for(int i=0;i<row;i++)
        Arrays.fill(dp[i],-1);
   

        return f(row-1,col-1,grid,dp);
    }
}