class Solution {
    public int minCostClimbingStairs(int[] cost) {
     //   https://www.youtube.com/watch?v=ktmzAZWkEZ0&list=PLot-Xpze53lcvx_tjrr_m2lgD2NsRHlNO&index=38
        int n = cost.length;
        // creating new array to add goal index with value 0
        int ar[] = new int[n+1];
        // adding zero as goal value
        ar[n] = 0;
        // copying cost
        for( int i=0; i<n;i++){
            ar[i] = cost[i];
        }

        int m = ar.length;

        for(int i=m-3; i>=0;i--){
            ar[i] += Math.min(ar[i+1], ar[i+2]);
        }
        for(int i : ar)
        System.out.println(i);

        return Math.min(ar[0],ar[1]);

        
    }
}