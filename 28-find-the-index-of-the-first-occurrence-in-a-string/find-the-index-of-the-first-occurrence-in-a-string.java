class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle .length();
        int m = haystack.length();

        int i=0;
        while(i<m){
            if(needle.charAt(0) == haystack.charAt(i) && (i+n <=m)){
                if(needle.equals(haystack.substring(i,i+n))) return i;
            }
              i++;
        }
        return -1;
        
    }
}