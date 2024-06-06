// class Solution {
//     public int longestPalindrome(String s) {
//         HashMap<Character,Integer> map = new HashMap<>();
//         char c[] = s.toCharArray();
//         for(char i : c){
//         map.put(i, map.getOrDefault(i, 0) + 1);
//         }
//         boolean isOdd = false;
//         int odd = 0;
//         int ans = 0;

//         for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//             int key = entry.getKey();
//             int value = entry.getValue();

//             if(value % 2 == 0) ans += value;
//             else{
//                 ans += value-1;
//                 isOdd = true;

//             }
//         }

//         if(isOdd) return ans+1;
//         else return ans;

            



        
//     }
// }


class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans=0;
        for(char i : s.toCharArray()){
            if(set.contains(i)){
                set.remove(i);
                ans+=2;
            }
            else {
                set.add(i);
            }
        }
        if(!set.isEmpty()) return ans+1;
        else return ans;

        

    }
}