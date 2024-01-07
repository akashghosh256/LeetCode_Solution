// class Solution {
//     public String minWindow(String s, String t) {
        
//     }
// }
import java.util.*;

public class Solution {

    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;
        
        int counter = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
        
        while (end < s.length()) {
            System.out.println(s.charAt(end));
            if (map[s.charAt(end++)]-- > 0) counter--; // in t
            System.out.println(" ---counter-> "+counter);
            
            while (counter == 0) { // valid
             System.out.println("");
                if (end - begin < d)  d = end - (head = begin);

               System.out.println("--end->"+end+"--head->"+head+"--d-->"+d);

                if (map[s.charAt(begin)]++ == 0) counter++; // make it invalid
                begin++;
                
                 System.out.println("while 2 counter-->"+ counter+"--begin->"+begin);
            }
        }
        
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
}