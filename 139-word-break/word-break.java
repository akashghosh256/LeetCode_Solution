//  RECURSIVE SOLN

//class Solution {
//     private boolean wb(String s, Set<String> set){
//         int len = s.length();
//         if(len == 0){
//             return true;
//         }
//         for(int i=1;i<=len;i++){
//             if(set.contains(s.substring(0,i)) && wb(s.substring(i),set))
//             return true;
//         }
//         return false;

//     }


//     public boolean wordBreak(String s, List<String> wordDict) {
//         Set<String> set = new HashSet<>(wordDict);
//         return wb(s,set);
//     }
// }


// Memoization TECHNIQUE
// import java.util.*;

// class Solution {
//     private Boolean[] memo; // Memoization array

//     private boolean wb(String s, Set<String> set) {
//         int len = s.length();
//         if (len == 0) {
//             return true;
//         }
//         if (memo[len] != null) {
//             return memo[len];
//         }
//         for (int i = 1; i <= len; i++) {
//             if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
//                 memo[len] = true;
//                 return true;
//             }
//         }
//         memo[len] = false;
//         return false;
//     }
// // In the provided code, the memo array is of type Boolean[] and has a length of s.length() + 1, where s is the input string. The memo array is used to store the results of previously computed substrings. Each index i of the memo array corresponds to the length of the substring s.substring(0, i).
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Set<String> set = new HashSet<>(wordDict);
//         memo = new Boolean[s.length() + 1];
//         return wb(s, set);
//     }
// }


// Bottom-Up Dynamic Programming approach
import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // In this code, the loop iterates over all possible i values, and for each i, it iterates over j from i - 1 to 0. The substring(j, i) operation extracts a valid substring from index j (inclusive) to index i - 1 (exclusive).
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to continue checking
                }
            }
        }

        return dp[n];
    }
}