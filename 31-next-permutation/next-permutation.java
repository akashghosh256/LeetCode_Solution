class Solution {

    public static void reverseArray(int[] arr, int start, int end) {
    while (start < end) {
        // Swap elements at start and end positions
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        // Move start position forward
        start++;

        // Move end position backward
        end--;
    }
}
    public void nextPermutation(int[] nums) {
       int n = nums.length;
       int ind = -1;
        // break point 
       for(int i= n-2 ; i >= 0 ; i--){
            if(nums[i] < nums[i+1])
            {
                ind = i;
                break;
            }
       }


       if (ind == -1){
           reverseArray(nums, 0 , n-1);
           return;
       } 

  for(int i= n-1 ; i > ind ; i--){
            if(nums[ind] < nums[i])
            {
              int temp = nums[i];
              nums[i] = nums[ind];
              nums[ind] = temp;
                break;
            }
       }
        reverseArray(nums, ind+1, n-1);
        return ;


    }
}