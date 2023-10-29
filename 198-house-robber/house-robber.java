// class Solution {

//     private int f(int[] a, int l){
//         if( l==0) return a[0];
//         if( l<0 ) return 0;
//         int notPick = 0 + f(a,l-1);
//         int pick = a[l] + f(a,l-2);

//         return Math.max(pick,notPick);



//     }


//     public int rob(int[] nums) {
//         int l = nums.length;
//          return f(nums,l-1);

//     }
// }


// Memoization
// class Solution {

//     private int f(int[] a, int l, int[] dp){
//         if( l==0) return a[0];
//         if( l<0 ) return 0;
//         if( dp[l] != -1) return dp[l];
//         int notPick = 0 + f(a,l-1,dp);
//         int pick = a[l] + f(a,l-2,dp);

//         return dp[l] = Math.max(pick,notPick);



//     }


//     public int rob(int[] nums) {
//         int l = nums.length;
//         int [] dp = new int[l];
//         Arrays.fill(dp,-1);



//          return f(nums,l-1,dp);

//     }
// }

// Tabulation

class Solution {

    private int f(int[] nums, int l, int[] dp){
    dp[0] = nums[0];

    for( int i =1; i<=l; i++){

 int pick = nums[i];

 if( i>1 )
 pick  +=  dp[i-2];


 int notPick = dp[i-1];

 dp[i] = Math.max(pick,notPick); 



    }
return dp[l];
    }
    


    public int rob(int[] nums) {
        int l = nums.length;
        int [] dp = new int[l];
        Arrays.fill(dp,-1);

    



         return f(nums,l-1,dp);

    }
}