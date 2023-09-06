// class Solution {
//     public int strStr(String haystack, String needle) {
//         int n = needle .length();
//         int m = haystack.length();
    

//         int i=0;
//         while(i<m){
//         // if a character matches the any character of haystack then we use 
//         // substring to pick up the string and match with needle else we move ahead
//             if(needle.charAt(0) == haystack.charAt(i) && (i+n <=m)){
//                 if(needle.equals(haystack.substring(i,i+n))) return i;
//             }
//               i++;
//         }
//         return -1;
        
//     }
// }

// // time complexity is O(m * n), where m is the length of the haystack string, and n is the length of the needle string.
// //  space complexity is O(n) for the substring created inside the loop.





//Knuth-Morris-Pratt (KMP) string searching algorithm
public class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        
        if (n == 0) {
            return 0; // Empty needle is always a match.
        }
        
        int[] lps = computeLPS(needle); //computeLPS stands for "Compute Longest Prefix Suffix"
       
       // Just for debugging
        // for(int i : lps)
        // System.out.println(i);
        
        int i = 0, j = 0;
        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    return i - n; // Match found.
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1]; // Use LPS to skip characters.
                } else {
                    i++; // No match, move to the next character in haystack.
                }
            }
        }
        
        return -1; // No match found.
    }
    
    private int[] computeLPS(String needle) {
//computeLPS stands for "Compute Longest Prefix Suffix"
        int n = needle.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        
        while (i < n) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}




