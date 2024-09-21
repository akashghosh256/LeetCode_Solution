// class Solution {
//     public int firstMissingPositive(int[] nums) {

//         // Approach 1 
//         // sc O(n) TC=O(n)

//         int n = nums.length;
//         boolean check[] = new boolean[n + 1];
        
//         for (int i = 0; i < n; i++) {
//             if (nums[i] > 0 && nums[i] <= n) {
//                 check[nums[i] - 1] = true;
//             }
//         }

//         for (int i = 0; i < n; i++) {
//             if (!check[i]) {
//                 return i + 1;
//             }
//         }

//         return n + 1;
//     }
// }

class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        boolean onePresent = false;

        // Check if '1' is present and convert invalid numbers to 1
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) onePresent = true;
            // Replace numbers that are out of range or non-positive
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        // If '1' is not present, return 1
        if (!onePresent) return 1;

        // Mark elements by setting the corresponding index to negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // Find the first index which is not negative
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1; // If all numbers from 1 to n are present
    }
}
