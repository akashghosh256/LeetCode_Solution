class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxS = nums[0];
        int sum =0;
        for(int n : nums){
            if( sum < 0){
                sum =0;
            }

            sum += n;
            maxS = Math.max(maxS, sum);
        }

        return maxS;





    }
}