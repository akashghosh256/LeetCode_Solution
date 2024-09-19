

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int result = findMinSquares(n, dp);
        return result;
    }

    // Recursive function with memoization (pick/not-pick approach)
    public int findMinSquares(int n, int[] dp) {
        if (n == 0) return 0; // Base case: if n is 0, no squares are needed

        if (dp[n] != -1) return dp[n]; // Return cached result if available

        int minSquares = Integer.MAX_VALUE;

        // Try all perfect squares <= n
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            int subResult = findMinSquares(n - square, dp);
            if (subResult != Integer.MAX_VALUE) {
                minSquares = Math.min(minSquares, subResult + 1); // Pick the square
            }
        }

        // Store the result in dp array
        dp[n] = minSquares;
        return minSquares;
    }
}
