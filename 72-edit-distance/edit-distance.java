// class Solution {

//     int f(int i, int j, String s1, String s2, int dp[][]){
//         if(i<0) return j+1;
//         if( j<0) return i+1;

//         if(dp[i][j] != -1) return dp[i][j];

//         if(s1.charAt(i)== s2.charAt(j))  return dp[i][j]= 0 + f(i-1,j-1,s1,s2,dp);

//         return dp[i][j] = 1 + Math.min(f(i,j-1,s1,s2,dp), Math.min(f(i-1,j,s1,s2,dp),f(i-1,j-1,s1,s2,dp)));
    



//     }


//     public int minDistance(String word1, String word2) {
//         int n = word1.length();
//         int m = word2.length();
//         int dp[][] = new int[n][m];
//         for(int row[]: dp)
//         Arrays.fill(row,-1);

//         return f(n-1,m-1,word1,word2,dp);

//     }
// }










// class Solution {



//     public int minDistance(String word1, String word2) {
//         int n = word1.length();
//         int m = word2.length();
    
//     int[][] dp=new int[n+1][m+1];
//      for(int i=0;i<=n;i++){
//         dp[i][0] = i;
//     }
//     for(int j=0;j<=m;j++){
//         dp[0][j] = j;
//     }
    
//     for(int i=1;i<n+1;i++){
//         for(int j=1;j<m+1;j++){
//             if(word1.charAt(i-1)==word2.charAt(j-1))
//                 dp[i][j] = 0+dp[i-1][j-1];
            
//             else dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
//         }
//     }
    
//     return dp[n][m];

//     }
// }








class Solution {



    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
    
  int[] prev=new int[m+1];
    int[] cur=new int[m+1];
    
    for(int j=0;j<=m;j++){
        prev[j] = j;
    }
    
    for(int i=1;i<n+1;i++){
        cur[0]=i;
        for(int j=1;j<m+1;j++){
            if(word1.charAt(i-1)==word2.charAt(j-1))
                cur[j] = 0+prev[j-1];
            
            else cur[j] = 1+Math.min(prev[j-1],Math.min(prev[j],cur[j-1]));
        }
        prev = (int[])(cur.clone());
    }
    
    return prev[m];

    }
}