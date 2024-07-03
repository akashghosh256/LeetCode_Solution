class Solution {
    public boolean isArraySpecial(int[] nums) {
        
        // parity = odd,even,odd,even....
        for(int i=1; i<nums.length; i++){
            if(nums[i]%2 == nums[i-1]%2)
            return false;
        }

        return true;



    }
}