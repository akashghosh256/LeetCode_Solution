class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle .length();
        int m = haystack.length();
    

        int i=0;
        while(i<m){
        // if a character matches the any character of haystack then we use 
        // substring to pick up the string and match with needle else we move ahead
            if(needle.charAt(0) == haystack.charAt(i) && (i+n <=m)){
                if(needle.equals(haystack.substring(i,i+n))) return i;
            }
              i++;
        }
        return -1;
        
    }
}

// time complexity is O(m * n), where m is the length of the haystack string, and n is the length of the needle string.
//  space complexity is O(n) for the substring created inside the loop.