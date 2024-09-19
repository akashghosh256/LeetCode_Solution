class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int result = findMinCoins(coins, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    // Recursive function with memoization (pick/not-pick approach)
    public int findMinCoins(int[] coins, int amount, int[] dp) {
        if (amount == 0) return 0; // Base case: no amount left to change

        if (dp[amount] != -1) return dp[amount]; // Return cached result if available

        int minCoins = Integer.MAX_VALUE;
        
        // Try picking each coin
        for (int coin : coins) {
            if (amount - coin >= 0) {
                int subResult = findMinCoins(coins, amount - coin, dp);
                if (subResult != Integer.MAX_VALUE) {
                    minCoins = Math.min(minCoins, subResult + 1); // Pick the coin
                }
            }
        }

        // Store the result in dp array
        dp[amount] = minCoins;
        return minCoins;
    }
}
