//  https://www.youtube.com/watch?v=pMU1pwHBu1U&t=109s&ab_channel=codestorywithMIK


// class Solution {
//     int M = 1000000007;

//     // Recursive function without memoization
//     long solve(char ch, int n) {
//         if (n == 0) {
//             return 1;
//         }

//         // Transition rules based on vowel following conditions
//         if (ch == 'a') {
//             return solve('e', n - 1) % M;
//         } else if (ch == 'e') {
//             return (solve('a', n - 1) + solve('i', n - 1)) % M;
//         } else if (ch == 'i') {
//             return (solve('a', n - 1) + solve('e', n - 1) + solve('o', n - 1) + solve('u', n - 1)) % M;
//         } else if (ch == 'o') {
//             return (solve('i', n - 1) + solve('u', n - 1)) % M;
//         } else { // ch == 'u'
//             return solve('a', n - 1);
//         }
//     }

//     public int countVowelPermutation(int n) {
//         long result = 0;
//     // bhai ek option toh chal hea gaya na isliye n-1
//         result = (result + solve('a', n - 1)) % M;
//         result = (result + solve('e', n - 1)) % M;
//         result = (result + solve('i', n - 1)) % M;
//         result = (result + solve('o', n - 1)) % M;
//         result = (result + solve('u', n - 1)) % M;

//         return (int) result;
//     }
// }


// import java.util.Arrays;

// class Solution {
//     int M = 1000000007;
//     int a = 0, e = 1, i = 2, o = 3, u = 4;
//     long[][] t;

//     // Helper function for recursion
//     long solve(int ch, int n) {
//         if (n == 0) {
//             return 1;
//         }

//         if (t[ch][n] != -1) {
//             return t[ch][n];
//         }

//         // Transition rules based on vowel following conditions
//         if (ch == a) {
//             t[ch][n] = solve(e, n - 1) % M;
//         } else if (ch == e) {
//             t[ch][n] = (solve(a, n - 1) + solve(i, n - 1)) % M;
//         } else if (ch == i) {
//             t[ch][n] = (solve(a, n - 1) + solve(e, n - 1) + solve(o, n - 1) + solve(u, n - 1)) % M;
//         } else if (ch == o) {
//             t[ch][n] = (solve(i, n - 1) + solve(u, n - 1)) % M;
//         } else { // ch == u
//             t[ch][n] = solve(a, n - 1);
//         }

//         return t[ch][n];
//     }

//     public int countVowelPermutation(int n) {
//         t = new long[5][n + 1]; // Create memoization table
//         for (long[] row : t) {
//             Arrays.fill(row, -1); // Initialize with -1
//         }

//         long result = 0;
//         result = (result + solve(a, n - 1)) % M;
//         result = (result + solve(e, n - 1)) % M;
//         result = (result + solve(i, n - 1)) % M;
//         result = (result + solve(o, n - 1)) % M;
//         result = (result + solve(u, n - 1)) % M;

//         return (int) result;
//     }
// }

public class Solution {
    private static final int M = 1000000007;
    private static final int a = 0, e = 1, i = 2, o = 3, u = 4;

    public int countVowelPermutation(int n) {
        long[][] t = new long[5][n + 1];

        for (int vowel = 0; vowel <= 4; vowel++) {
            t[vowel][1] = 1;
        }

        for (int len = 2; len <= n; len++) {
            t[a][len] = (t[e][len - 1] + t[i][len - 1] + t[u][len - 1]) % M;
            t[e][len] = (t[a][len - 1] + t[i][len - 1]) % M;
            t[i][len] = (t[e][len - 1] + t[o][len - 1]) % M;
            t[o][len] = t[i][len - 1] % M;
            t[u][len] = (t[i][len - 1] + t[o][len - 1]) % M;
        }

        long result = 0;
        for (int vowel = 0; vowel <= 4; vowel++) {
            result = (result + t[vowel][n]) % M;
        }

        return (int) result;
    }
}