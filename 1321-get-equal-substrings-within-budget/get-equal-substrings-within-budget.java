class Solution {
    public int equalSubstring(String s, String t, int maxCost) {

        // sliding window 
        // https://www.youtube.com/watch?v=MF2MgJQuFhA
     int n = s.length();
     int maxLen = 0;
     int curCost = 0;
     int i=0, j=0;

     while(j<n){
        curCost += Math.abs(t.charAt(j) - s.charAt(j));

        while(curCost > maxCost){
            curCost -= Math.abs(t.charAt(i) - s.charAt(i));
            i++;
        }

        maxLen = Math.max(maxLen, (j-i+1));
        j++;

     }

     return maxLen;

    }
}