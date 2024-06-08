class Solution {
    public int countTriplets(int[] arr) {
        int xor = 0;
        int ans = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i< arr.length; i++){
            xor ^= arr[i];
            if( xor == 0){
                ans +=i;
            }
        if(map.containsKey(xor)){
                for( int j : map.get(xor))
                ans += (i-j-1);
            }

        List<Integer> indexes = map.getOrDefault(xor,new ArrayList<>());
         indexes.add(i);
         map.put(xor,indexes);

        }
        return ans;


    }
}