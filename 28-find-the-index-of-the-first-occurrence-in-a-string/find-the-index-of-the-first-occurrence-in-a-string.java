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





//Knuth-Morris-Pratt (KMP) string searching algorithm-------------------------------


//   public class Solution {
//     public int strStr(String haystack, String needle) {
//         int m = haystack.length();
//         int n = needle.length();
        
//         if (n == 0) {
//             return 0; // Empty needle is always a match.
//         }
        
//         int[] lps = computeLPS(needle); //computeLPS stands for "Compute Longest Prefix Suffix"
       
//        // Just for debugging
//         // for(int i : lps)
//         // System.out.println(i);
        
//         int i = 0, j = 0;
//         while (i < m) {
//             if (haystack.charAt(i) == needle.charAt(j)) {
//                 i++;
//                 j++;
//                 if (j == n) {
//                     return i - n; // Match found.
//                 }
//             } else {
//                 if (j != 0) {
//                     j = lps[j - 1]; // Use LPS to skip characters.
//                 } else {
//                     i++; // No match, move to the next character in haystack.
//                 }
//             }
//         }
        
//         return -1; // No match found.
//     }
    
//     private int[] computeLPS(String needle) {
// //computeLPS stands for "Compute Longest Prefix Suffix"
//         int n = needle.length();
//         int[] lps = new int[n];
//         int len = 0;
//         int i = 1;
        
//         while (i < n) {
//             if (needle.charAt(i) == needle.charAt(len)) {
//                 len++;
//                 lps[i] = len;
//                 i++;
//             } else {
//                 if (len != 0) {
//                     len = lps[len - 1];
//                 } else {
//                     lps[i] = 0;
//                     i++;
//                 }
//             }
//         }
        
//         return lps;
//     }
// }



// TC - O(m+n)  SC - 0(n) where m is the length of the haystack string, and n is the length of the needle string.












// Z Alogorithm-------------------------------------------------------------------------



public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0; // Empty needle is always a match.
        }
        
        String concatenated = needle + "$" + haystack;
        int[] zArray = calculateZArray(concatenated);
        
        for (int i = 0; i < zArray.length; i++) {
            if (zArray[i] == needle.length()) {
                return i - needle.length() - 1; // Match found.
            }
        }
        
        return -1; // No match found.
    }
    
    private int[] calculateZArray(String s) {
        int n = s.length();
        int[] zArray = new int[n];
        int left = 0;
        int right = 0;
        
        for (int i = 1; i < n; i++) {
            if (i > right) {
                left = right = i;
                while (right < n && s.charAt(right - left) == s.charAt(right)) {
                    right++;
                }
                zArray[i] = right - left;
                right--;
            } else {
                int k = i - left;
                if (zArray[k] < right - i + 1) {
                    zArray[i] = zArray[k];
                } else {
                    left = i;
                    while (right < n && s.charAt(right - left) == s.charAt(right)) {
                        right++;
                    }
                    zArray[i] = right - left;
                    right--;
                }
            }
        }
        
        return zArray;
    }
}


// Time Complexity (TC): The Z algorithm has a linear time complexity of O(m + n), where 'm' is the length of the pattern (needle), and 'n' is the length of the text (haystack). This means that the time it takes to search for all occurrences of the pattern within the text is directly proportional to the combined length of the pattern and the text.

// Constructing the Z-array takes O(m + n) time, as it involves iterating through the concatenated string of length (m + n).
// Scanning the Z-array to find matches also takes O(m + n) time in the worst case.
// The Z algorithm is efficient and performs well for substring search tasks, especially when you need to find all occurrences of a pattern in a text.

// Space Complexity (SC): The space complexity of the Z algorithm is O(m + n), where 'm' is the length of the pattern (needle), and 'n' is the length of the text (haystack). This space complexity is mainly due to the storage of the Z-array.

// The Z-array itself requires O(m + n) space.
// Other variables used in the algorithm typically require constant space.