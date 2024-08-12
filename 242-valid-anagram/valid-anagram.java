class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        int alpha[] = new int [27];

        for(char c : s.toCharArray())
         alpha[c-'a']++;


     for(char c : t.toCharArray()){
         if( alpha[c-'a'] > 0) alpha[c-'a']--;
         else return false;
     }

     return true;




        
    }
}