class Solution {
    public int minOperations(int[] nums) {

        //https://www.youtube.com/watch?v=lkPNh2M1lUs&ab_channel=codestorywithMIK
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int it : nums)
        map.put(it, map.getOrDefault(it,0) +1);

        int steps = 0;

      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if(entry.getValue() == 1) return -1;
        steps += Math.ceil(((double)entry.getValue())/3.0);
      }

return steps;


    }
}