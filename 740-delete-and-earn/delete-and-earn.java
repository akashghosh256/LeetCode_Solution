class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max_val = 0;
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
            max_val = Math.max(max_val,ele);
        }

        int[][] dp = new int[max_val+1][2];
        for(int i=1;i<=max_val;i++){
           if(!map.containsKey(i)){
               dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
               dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
               continue;
           }
           
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + i*map.get(i);

            
        }
        
        return Math.max(dp[max_val][0],dp[max_val][1]);
    }
}