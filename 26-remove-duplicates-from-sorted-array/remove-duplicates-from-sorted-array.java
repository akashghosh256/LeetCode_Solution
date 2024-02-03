class Solution {
    public int removeDuplicates(int[] nums) {
        // 1 hashset
        // 2 pointer
        int i=0;
        for(int j=1; j<nums.length;j++){
            if(nums[i] != nums[j])
        {
            i++;
            nums[i] = nums[j];            
        }else continue;
        }
        return i+1;
    }
}