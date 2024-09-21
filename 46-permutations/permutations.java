import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;
    
    public void solve(int idx, int[] nums) {
        if (idx == n) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : nums) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }
        
        for (int i = idx; i < n; i++) {
            // Swap elements
            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;
            
            solve(idx + 1, nums);
            
            // Backtrack (swap back)
            temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        solve(0, nums);
        return result;
    }
}
