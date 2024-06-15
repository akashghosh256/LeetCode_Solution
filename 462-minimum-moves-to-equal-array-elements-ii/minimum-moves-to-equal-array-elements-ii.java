class Solution {
public int minMoves2(int[] nums) {

    
// int result = 0, length = nums.length;
// Arrays.sort(nums);
// int median = length / 2;
// for (int i = 0; i < length; i++) {
// result += Math.abs(nums[i] - nums[median]);
// }
// return result;




 //sort the array
        Arrays.sort(nums);

        //Calculate the steps by tsking 2 pointers
        int i=0;
        int j = nums.length-1;
        int steps = 0;

        while(i < j){
            steps += (nums[j] - nums[i]);
            i++;
            j--;
        }
        return steps;
}
}