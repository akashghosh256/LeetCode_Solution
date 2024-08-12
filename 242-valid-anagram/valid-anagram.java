class Solution {
    public boolean isAnagram(String s, String t) {

//     if( s.length() != t.length()) return false;
//     HashMap <Character, Integer> map = new HashMap<>();
//     HashMap <Character, Integer> map2 = new HashMap<>();

//  for (char c : s.toCharArray()) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }
//      for (char c : t.toCharArray()) {
//             map2.put(c, map2.getOrDefault(c, 0) + 1);
//         }

//     for( char c : s.toCharArray()){
//         if(map.get(c) != map2.get(c)) return false;
//     }
//     return true;

if( s.length() != t.length()) return false;
int [] alphabet = new int[26];

for(char c : s.toCharArray()){
alphabet[c-'a']++;
}

for(char c : t.toCharArray()){
   if(alphabet[c -'a'] > 0) alphabet[c -'a']--;
   else return false;
}

return true;


    }
}