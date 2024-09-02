class Solution {

    int helper(int i, int j, int m, int n, int dp[][], int[][] obstacleGrid) {
        if (i == m-1 && j == n-1) return obstacleGrid[i][j] == 1 ? 0 : 1;
        if (i >= m || j >= n) return 0;
        if (obstacleGrid[i][j] == 1) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = helper(i + 1, j, m, n, dp, obstacleGrid) + 
                          helper(i, j + 1, m, n, dp, obstacleGrid);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // Edge case: if the start or end cell is an obstacle
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;

        int dp[][] = new int[m][n];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return helper(0, 0, m, n, dp, obstacleGrid);
    }
}
