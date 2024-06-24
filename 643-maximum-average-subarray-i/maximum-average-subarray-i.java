class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double pow = 100000;
        double temp =0;
        for(int i=0; i<k;i++)
        temp += nums[i];

        double ans = (temp / k);
     //   System.out.println(ans);
        for(int i=k; i<n; i++){
            temp += nums[i] - nums[i-k];
     //   System.out.println(temp/k);
            ans = Math.max(ans, (double)(temp/k));
        }
        return ans%pow;
        
    }
}