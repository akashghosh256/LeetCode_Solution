class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer, Integer> map = new HashMap<>();
        for(int i : nums){
           map.put(i, map.getOrDefault(i,0)+1); 

        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(int[]a , int[]b ){
                return b[1] - a[1];
            }
        });

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){ 
            int arr[] = {entry.getKey(), entry.getValue()};
            pq.add(arr);
        }
        int ans[] = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = pq.poll()[0];
        }
        return ans;

        
    }
}