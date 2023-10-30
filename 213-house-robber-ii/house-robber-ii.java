

//Memoization
class Solution {

    private int f(int[] a, int l, int[] dp){
        if( l==0) return a[0];
        if( l<0 ) return 0;
        if( dp[l] != -1) return dp[l];
        int notPick = 0 + f(a,l-1,dp);
        int pick = a[l] + f(a,l-2,dp);

        return dp[l] = Math.max(pick,notPick);



    }


    public int rob(int[] nums) {
        int n = nums.length;
        if( n == 1 ) return nums[0];

        int a1[] = new int[n-1];
        int a2[] = new int[n-1];

        for(int i=0; i<n;i++){
            if( i !=0 ) a1[i-1] = nums[i];
            if(i != n-1) a2[i] = nums[i];
        }



        int [] dp = new int[n];
        Arrays.fill(dp,-1);
        int ans1 = f(a1,n-2,dp);
       // int [] dp = new int[n];
        Arrays.fill(dp,-1);
        int ans2 = f(a2,n-2,dp);



         return Math.max(ans1,ans2);

    }
}