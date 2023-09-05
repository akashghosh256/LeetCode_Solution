import java.util.*;
class Solution {
    public boolean wordPattern(String pattern, String s) {
        if(pattern == null || s == null) return false;
        String[] words = s.split("\\s+");
        // for(String i : words)
        //   System.out.println(i);


        if(pattern.length() != words.length) return false;

        HashMap<Character,String> map = new HashMap();
         Set<String> set = new HashSet<>();

        int i=0;

        while(i < pattern.length()){

            if(map.containsKey(pattern.charAt(i))){
              
                if(map.get(pattern.charAt(i)).equals(words[i]) == false) return false;

            }
            else{
               if(set.contains(words[i])) return false;
                map.put(pattern.charAt(i),words[i]);
                set.add(words[i]);
            }
            i++;


        }


        
return true;



    }
}