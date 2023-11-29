// Two pointerrrrrrrrrrrrrrrrrrrrrrrrrrrrrr

class Solution {
    public String removeDuplicates(String s) {
        int n = s.length(), i=0;
char res[] = s.toCharArray();
for( int j=0; j<n;j++,i++){
    res[i]= res[j];
    if(i>0 && res[i] == res[i-1]) i-=2;
}

return new String(res, 0, i);


    }
}





// stack-----------------------------
// class Solution {
//     public String removeDuplicates(String s) {
//         int n = s.length();
//         if(n <= 1) return s;
//         Stack<Character> st = new Stack<>();
   
//         for(int i=0; i<n;i++){
//             if(st.isEmpty()) st.push(s.charAt(i));
//             else{
//                 if(st.peek() == s.charAt(i)){
//                     st.pop();
//                 }
//                 else st.push(s.charAt(i));
//             }

//         }
// 	StringBuilder str = new StringBuilder();
//     while(!st.isEmpty()) str.append(st.pop());
//     str.reverse();
//     return (str.toString());

//     }
// }