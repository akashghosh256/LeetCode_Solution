

class Solution {
  private static class Pair{
   char s;
    int v;
   public Pair(char s, int v){
       this.s = s;
       this.v = v;
   }

   public char getKey(){
       return s;
   }

   public int getValue(){
       return v;
   }
}
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Pair> st= new Stack<>();
        for(int i=0; i<n; i++){
        if(st.isEmpty() || st.peek().getKey() != s.charAt(i)){
            st.push(new Pair(s.charAt(i), 1));
        }
        else{
             Pair prev = st.pop();
            st.push(new Pair(s.charAt(i), prev.getValue() + 1));
        }

        if( st.peek().getValue() == k) st.pop();

        }
        StringBuilder ans = new StringBuilder();

        while(!st.isEmpty()){
            Pair cur = st.pop();
            int count = cur.getValue();
        while(count-- > 0){
            ans.append(cur.getKey());
        }
       

        }      
    

return ans.reverse().toString();
    }

}
















// class Solution {
//     public String removeDuplicates(String s, int k) {
//        int i = 0, n = s.length(), count[] = new int[n];
//         char[] stack = s.toCharArray();
//         for (int j = 0; j < n; ++j, ++i) {
//             stack[i] = stack[j];
//             count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
//             if (count[i] == k) i -= k;
//         }
//         return new String(stack, 0, i);  
//     }
// }













