class Solution {
    public int maxSubArray(int[] nums) {
        // kadanes algo 
        int ans = nums[0];
        int sum=0;
        int start = 0;
        int end = 0;

        for(int i=0 ; i<nums.length; i++){
            if( sum <0){
                sum = 0;
                start = i;
            }
            sum += nums[i];
            if(sum > ans){
                ans = sum;
                end = i;
            }
            

        }

     System.out.println("Longest subarray is ");
        for(int i=start; i<=end; i++){
            System.out.print(nums[i]+",");
        }



        return ans;


    }
}