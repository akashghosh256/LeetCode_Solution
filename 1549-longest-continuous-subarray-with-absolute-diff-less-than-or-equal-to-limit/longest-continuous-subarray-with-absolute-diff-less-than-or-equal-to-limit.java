class Solution {
    public int longestSubarray(int[] nums, int limit) {

        PriorityQueue<Integer> max =  new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        int i=0, j=0;
        int ans = 1;
        int n = nums.length;

        max.add(nums[0]);
        min.add(nums[0]);

        while(j<n-1){
            int mx = max.peek();
            int mn = min.peek();

            if((mx - mn) <= limit){
                ans = Math.max(ans, (j-i+1));
                j++;
                max.add(nums[j]);
                min.add(nums[j]);
            }
            else{
                max.remove(nums[i]);
                min.remove(nums[i]);
                i++;
            }



        }

        // for last element
        if( max.peek() - min.peek() <= limit)
        ans = Math.max(ans, (j-i+1));

        return ans;




        
    }
}