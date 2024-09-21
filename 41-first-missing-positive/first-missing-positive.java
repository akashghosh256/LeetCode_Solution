class Solution {
    public int firstMissingPositive(int[] nums) {

        // Approach 1 
        // sc O(n) TC=O(n)

        int n = nums.length;
        boolean check[] = new boolean[n + 1];
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] <= n) {
                check[nums[i] - 1] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
