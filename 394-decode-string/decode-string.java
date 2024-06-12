class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        char ch[] = s.toCharArray();

        for(int i=0; i<s.length(); i++){
            if(ch[i] != ']')
            st.push(ch[i]);
            else{
              //  StringBuilder st = new StringBuilder();
              String str="";
                while(st.peek() != '['){
                    str = st.pop() + str;
                }
                st.pop(); // to remove last [

                String freq="";
                 while(!st.isEmpty() && Character.isDigit(st.peek())){
                freq = st.pop() + freq;
                 }
                  int n = Integer.parseInt(freq);

                  
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < n; k++) {
            sb.append(str);
        }
        
        String ns = sb.toString();
        char nc[] =ns.toCharArray();
      for( char c : nc) 
      st.push(c);




            }
        }

StringBuilder sb = new StringBuilder();
while(!st.isEmpty()){
    sb.append(st.pop());
}
sb.reverse();




        return sb.toString();

    }
}