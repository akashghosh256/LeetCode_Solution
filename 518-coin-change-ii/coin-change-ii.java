class Solution {
    
    private int count(int target, int[] coins, int ind, int dp[][]) {
        if (ind == 0) {
            if (target % coins[ind] == 0)
                return 1;
            else
                return 0;
        }

        if (dp[ind][target] != -1) return dp[ind][target];

        int notTaken = count(target, coins, ind - 1, dp);

        int taken = 0;

        if (coins[ind] <= target) {
            taken = count(target - coins[ind], coins, ind, dp);
        }

        return dp[ind][target] = taken + notTaken;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return count(amount, coins, n - 1, dp);
    }
}
