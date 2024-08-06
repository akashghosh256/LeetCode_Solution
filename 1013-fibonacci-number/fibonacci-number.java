class Solution {
// lets do dp
int solve(int n , int dp[]){
    if(n<2) return n;
    if(dp[n] != -1) return dp[n];

    return dp[n] = solve(n-1,dp) + solve(n-2, dp);

}


    public int fib(int n) {
      //   0,1,1,2,3...
        // if(n<2) return n;
        // return  fib(n-1) + fib(n-2);


        // dppppppppppppppppppppp

        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n, dp);



        
        // or 

    //     if(n<2) return n;
    //     int ar[] = new int[n+1];
    //  ar[0] = 0;
    //  ar[1] = 1;
    //  for(int i=2; i<=n; i++){
    //     ar[i] = ar[i-1] + ar[i-2];
    //  }
    //  return ar[n];



    }
}