import java.util.*;

// class Solution {
//     // reverse a[] from a[i] to a[j]
//     private void reverse(char[] a) {
//         int i = 0, j = a.length - 1;
//         while (i < j) {
//             char t = a[i];
//             a[i] = a[j];
//             a[j] = t;

//             i++;
//             j--;
//         }
//     }

//     public String reverseWords(String s) {
//         if (s == null) return null;
//         String ans = "";
//         StringTokenizer st = new StringTokenizer(s);
//         while (st.hasMoreTokens()) {
//             char[] a = st.nextToken().toCharArray();
//             reverse(a); // Reverse the character array
//             String str = new String(a);
//             ans += str;

//             // Add a space after each reversed word, except for the last one
//             if (st.hasMoreTokens()) {
//                 ans += " ";
//             }
//         }

//         return ans;
//     }
// }



class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;
        
        char[] chars = s.toCharArray();
        int start = 0;
        
        for (int end = 0; end < chars.length; end++) {
            if (chars[end] == ' ' || end == chars.length - 1) {
                reverseWord(chars, start, end == chars.length - 1 ? end : end - 1);
                start = end + 1;
            }
        }
        
        return new String(chars);
    }
    
    private void reverseWord(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
