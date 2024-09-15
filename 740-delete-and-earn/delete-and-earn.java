import java.util.*;

class Solution {

    // Helper function to calculate maximum points
    int helper(int points[], int i, int n, int dp[]) {
        if (i >= n) return 0; // Corrected the condition (i >= n)
 
        if(dp[i] != -1) return dp[i];

        // Pick the current element and move to i+2
        int pick = points[i] + helper(points, i + 2, n, dp);

        // Do not pick the current element and move to i+1
        int notPick = helper(points, i + 1, n, dp);

        // Return the maximum of the two choices
        return dp[i] =  Math.max(pick, notPick);
    }

    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int maxE = 0;

        // Find the maximum element in nums
        for (int i : nums) {
            maxE = Math.max(maxE, i);
        }

        // Create points array to store the sum of values
        int points[] = new int[maxE + 1];
        Arrays.fill(points, 0);

        // Populate the points array
        for (int i : nums) {
            points[i] += i;
        }

        int dp[] = new int[maxE + 1];
        Arrays.fill(dp,-1);

        // Call the helper function starting from index 1
        return helper(points, 1, maxE + 1, dp);
    }
}
