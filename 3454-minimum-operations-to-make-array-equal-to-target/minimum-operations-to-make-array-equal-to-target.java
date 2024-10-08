class Solution {
    public long minimumOperations(int[] nums, int[] target) {

        // https://www.youtube.com/watch?v=1KE3Wpoh_d4&list=PLEL7R4Pm6EmANcHWGHr9uoOFcm75Mkbqn&ab_channel=AryanMittal
        int n = nums.length;
        int diff[] = new int[n];
        Arrays.fill(diff,0);
        for(int i=0; i<n; i++)
        diff[i] = target[i] - nums[i];

        long  ans =0, incOp = 0, decOp= 0;
        for(int i=0; i<n;i++){
            if(diff[i] > 0){
                if(incOp < diff[i]){
                long extra = diff[i] - incOp;
                ans += (long) extra;
                }
                // it doesnt matter is current div is large or small we have to move according subarrary 
              incOp = diff[i];
              decOp =0;
        }
        else if(diff[i] < 0){
            if( decOp <  -diff[i]){
                long extra = -diff[i] - decOp;
                ans += (long)extra;
            }
            decOp = -diff[i];
            incOp = 0;
        }else{
            incOp = decOp = 0;
        }
      
    }
      return ans;
}
}