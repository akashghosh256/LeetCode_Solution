class Solution {

    public int f(int ind, int ar[], int k, int dp[]){
          int n = ar.length;

          if(ind == n) return 0;
          if(dp[ind] != -1) return dp[ind];
          int maxi = Integer.MIN_VALUE;
          int maxAns =  Integer.MIN_VALUE;
          int len =0;
          for(int i= ind; i< Math.min(n,ind+k);i++){
            len++;
            maxi = Math.max(maxi, ar[i]);
            int sum =  maxi * len + f(i+1, ar, k,dp);
            maxAns = Math.max(maxAns, sum);
          }

          return dp[ind] = maxAns;

    }


    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return f(0,arr,k,dp);
        
    }
}