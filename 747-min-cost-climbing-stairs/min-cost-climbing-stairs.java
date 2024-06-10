class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int ar[] = new int[n+2];
        ar[n] =0;
        for( int i=0; i<n;i++){
            ar[i] = cost[i];
        }

        int m = ar.length;

        for(int i=m-3; i>=0;i--){
            ar[i] += Math.min(ar[i+1], ar[i+2]);
        }

        return Math.min(ar[0],ar[1]);

        
    }
}