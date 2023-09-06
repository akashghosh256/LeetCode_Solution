class Solution {
    public boolean isAnagram(String s, String t) {

// The idea is simple. It creates a size 26 int arrays as buckets for each letter in alphabet. It increments the bucket value with String s and decrement with string t. So if they are anagrams, all buckets should remain with initial value which is zero or if values gets lower than 0 then also return false. So just checking that and return


      int [] alphabet= new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;

        for (int i = 0; i < t.length(); i++) 
        {  
          int count = alphabet[t.charAt(i) - 'a']--;
           if( count  < 0 ) return false;
           
       }
        for (int i : alphabet) if (i != 0) return false;
        return true;


    }
}


// Using Hashtable -----------------------------------------------

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         Map<Character, Integer> count = new HashMap<>();
        
//         // Count the frequency of characters in string s
//         for (char x : s.toCharArray()) {
//             count.put(x, count.getOrDefault(x, 0) + 1);
//         }
        
//         // Decrement the frequency of characters in string t
//         for (char x : t.toCharArray()) {
//             count.put(x, count.getOrDefault(x, 0) - 1);
//         }
        
//         // Check if any character has non-zero frequency
//         for (int val : count.values()) {
//             if (val != 0) {
//                 return false;
//             }
//         }
        
//         return true;
//     }
// }