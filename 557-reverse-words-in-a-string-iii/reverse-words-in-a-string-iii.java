import java.util.*;

class Solution {
    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a) {
        int i = 0, j = a.length - 1;
        while (i < j) {
            char t = a[i];
            a[i] = a[j];
            a[j] = t;

            i++;
            j--;
        }
    }

    public String reverseWords(String s) {
        if (s == null) return null;
        String ans = "";
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            char[] a = st.nextToken().toCharArray();
            reverse(a); // Reverse the character array
            String str = new String(a);
            ans += str;

            // Add a space after each reversed word, except for the last one
            if (st.hasMoreTokens()) {
                ans += " ";
            }
        }

        return ans;
    }
}
