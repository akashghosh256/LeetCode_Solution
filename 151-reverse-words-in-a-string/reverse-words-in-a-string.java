 import java.util.*;
// class Solution {
//     public String reverseWords(String s) {
//  s = s.trim();
//     s = s.replaceAll("\\s+", " ");
//     // Split the input string into words using space as a delimiter
//         String[] words = s.split(" ");
        
//         // Create a StringBuilder to store the reversed words
//         StringBuilder reversedString = new StringBuilder();
        
//         // Iterate through the words in reverse order and append them to the reversed string
//         for (int i = words.length - 1; i >= 0; i--) {
//             reversedString.append(words[i]);
            
//             // Add a space after each word, except for the last word
//             if (i > 0) {
//                 reversedString.append(" ");
//             }
//         }

//       return  reversedString.toString();
        

//     }
// }


//  Stack approach
// class Solution {
// public String reverseWords(String s) {
//         Stack<String> st = new Stack<String>();
//         for (String a : s.trim().split(" ")) {
//             if (!a.isEmpty())
//                 st.push(a);
//         }
        
//         StringBuilder sb = new StringBuilder();
//         while (!st.isEmpty()) {
//             sb.append(st.pop());
//             sb.append(" ");            
//         }
        
//         return sb.toString().trim();
//     }
// }

class Solution {
public String reverseWords(String s) {

 if (s == null) return null;
    
    char[] a = s.toCharArray();
    int n = a.length;
    
    // step 1. reverse the whole string
    reverse(a, 0, n - 1);
    // step 2. reverse each word
    reverseWords(a, n);
    // step 3. clean up spaces
    return cleanSpaces(a, n);
  }
  
  void reverseWords(char[] a, int n) {
    int i = 0, j = 0;
      
    while (i < n) {
      while (i < j || i < n && a[i] == ' ') i++; // skip spaces
      while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
      reverse(a, i, j - 1);                      // reverse the word
    }
  }
  
  // trim leading, trailing and multiple spaces
  String cleanSpaces(char[] a, int n) {
    int i = 0, j = 0;
      
    while (j < n) {
      while (j < n && a[j] == ' ') j++;             // skip spaces
      while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
      while (j < n && a[j] == ' ') j++;             // skip spaces
      if (j < n) a[i++] = ' ';                      // keep only one space
    }
  
    return new String(a).substring(0, i);
  }
  
  // reverse a[] from a[i] to a[j]
  private void reverse(char[] a, int i, int j) {
    while (i < j) {
      char t = a[i];
      a[i++] = a[j];
      a[j--] = t;
    }
  }

}



















