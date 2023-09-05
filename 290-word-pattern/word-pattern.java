import java.util.*;
class Solution {
    public boolean wordPattern(String pattern, String s) {
        if(pattern == null || s == null) return false;
        // converting String to words array for comparison
        String[] words = s.split("\\s+");
  

  //  pattern length should be equal to Number of words in string to follow the word pattern
        if(pattern.length() != words.length) return false;

//  To have check of correct characters with word
        HashMap<Character,String> map = new HashMap();

// To keep track and avoid duplicate string for different alphabets of pattern 
         Set<String> set = new HashSet<>();

        int i=0;

        while(i < pattern.length()){

            if(map.containsKey(pattern.charAt(i))){
              
                if(map.get(pattern.charAt(i)).equals(words[i]) == false) return false;

            }
            else{
               if(set.contains(words[i])) return false; // if set already contains the word it means the word is also related to some other alphabet of pattern which is not possible

               // add the word and character
                map.put(pattern.charAt(i),words[i]);
                set.add(words[i]);
            }

            
            i++;


        }


        
return true;



    }
}