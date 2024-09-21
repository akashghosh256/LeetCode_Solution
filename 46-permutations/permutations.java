import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> st = new HashSet<>();
    int n;
    
    public void solve(List<Integer> temp, int[] nums) {
        if (temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!st.contains(nums[i])) {
                temp.add(nums[i]);
                st.add(nums[i]);

                solve(temp, nums);

                st.remove(nums[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        
        List<Integer> temp = new ArrayList<>();
        
        solve(temp, nums);
        
        return result;
    }
}
