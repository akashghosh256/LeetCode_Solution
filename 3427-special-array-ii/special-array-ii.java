class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int prefSum [] = new int [n];
        Arrays.fill(prefSum, 0);

        for(int i=1; i<n;i++){
            prefSum[i] = prefSum[i-1];
            if(nums[i]%2 == nums[i-1]%2)
            prefSum[i]++;

        }

        int qn = queries.length;
        boolean ans[] = new boolean[qn];
        Arrays.fill(ans,true);
        for(int i=0; i<qn; i++){
            int u = queries[i][0];
            int v = queries[i][1];
               int count = prefSum[v] - prefSum[u];

               ans[i] = count >= 1 ? false : true;

        }

        return ans;


        
    }
}