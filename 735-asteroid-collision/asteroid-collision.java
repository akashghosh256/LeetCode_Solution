class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for(int i : asteroids){

            if(i > 0 || st.isEmpty()){
                st.push(i);
            }
            else {
                // negative
                while(!st.isEmpty() && st.peek() > 0  && st.peek() < Math.abs(i)){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == Math.abs(i)){
                    st.pop();
                }
                else{
                    if(st.isEmpty() || st.peek() < 0){
                        st.push(i);
                    }
                }
            }


        }
        int i = st.size();
        int ans[] = new int[i];
      
        while(!st.isEmpty()){
        ans[--i] = st.pop();
        
        }

    return ans;
        
    }
}