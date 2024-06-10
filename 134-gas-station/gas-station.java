class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans =0, diff=0, res=0;
    //kadanes algo
        for(int i=0; i<gas.length; i++){
            diff += (gas[i]-cost[i]);
            res += (gas[i] - cost[i]);

            if( res < 0){
                res=0;
                ans = i+1;

            }

        }
        if( diff < 0 || ans >= gas.length) return -1;
        return ans;




    }
}