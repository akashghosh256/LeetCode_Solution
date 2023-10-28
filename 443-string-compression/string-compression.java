import java.util.*;
class Solution {
    public int compress(char[] chars) {
        int l = chars.length;
        int i = 0;

        for(int j = 1, count=1; j <= l; j++,count++  ){
            if( j == l  || chars[j] != chars[j-1] ){
                chars[i] = chars[j-1];
                i++;

                if( count >= 2){
                    String c =  Integer.toString(count);
                   for (int k = 0; k < c.length(); k++) {
                        chars[i] = c.charAt(k);
                        i++;
                    }
                }
        count = 0;

            }
        }

        return i;



    }
}