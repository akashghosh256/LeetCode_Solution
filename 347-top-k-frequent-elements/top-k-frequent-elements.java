class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums)
        map.put(num,map.getOrDefault(num,0)+1);

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(
            (a,b) -> a.getValue() - b.getValue()
        );

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            minHeap.add(entry);

            if(minHeap.size() > k) minHeap.poll();
        }
        int ans [] = new int [k];
        int i=0;
         while(!minHeap.isEmpty()){
            ans[i++] = minHeap.poll().getKey();
         }

         return ans;
 
        
    }
}