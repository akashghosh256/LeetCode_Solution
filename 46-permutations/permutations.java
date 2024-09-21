class Solution {
    List<List<Integer>> ans = new ArrayList<>();
   HashSet<Integer> st = new HashSet<>();
    int n;

    void solve(List<Integer> temp, int[] nums){
        if(temp.size() == n){
            ans.add(new ArrayList<>(temp));
            return;       
        }
    

    for(int i=0; i<n; i++){
        if(!st.contains(nums[i])){
            st.add(nums[i]);
            temp.add(nums[i]);

            solve(temp, nums);

            st.remove(nums[i]);
            temp.remove(temp.size() -1);
        }

    }
    }


    public List<List<Integer>> permute(int[] nums) {
    n = nums.length;
    List<Integer> temp = new ArrayList<>();
     solve(temp,nums);
    return ans;
    }
}