import java.util.*;
class Solution {
    public String reverseWords(String s) {
 s = s.trim();
    s = s.replaceAll("\\s+", " ");
    // Split the input string into words using space as a delimiter
        String[] words = s.split(" ");
        
        // Create a StringBuilder to store the reversed words
        StringBuilder reversedString = new StringBuilder();
        
        // Iterate through the words in reverse order and append them to the reversed string
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString.append(words[i]);
            
            // Add a space after each word, except for the last word
            if (i > 0) {
                reversedString.append(" ");
            }
        }

      return  reversedString.toString();
        

    }
}