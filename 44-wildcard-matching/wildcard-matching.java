class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[j] means whether s[0..i-1] matches p[0..j-1]
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        // Initialize first row where s is empty
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[j] = dp[j - 1];
            }
        }
        
        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            boolean[] newDp = new boolean[n + 1];
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == '*') {
                    newDp[j] = dp[j] || newDp[j - 1];
                } else if (pc == '?' || sc == pc) {
                    newDp[j] = dp[j - 1];
                }
            }
            dp = newDp;
        }
        
        return dp[n];
    }
}