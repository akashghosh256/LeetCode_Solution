class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
      StringBuilder st = new StringBuilder();
        int n = s.length();
        char ss[] = s.toCharArray();

        for(int i=0; i<numRows; i++){
            int increment = (numRows - 1) * 2;
            for (int j=i; j<n; j+=increment){
                st.append(ss[j]);
                if ( i>0 && i<numRows-1 && (j+increment - 2*i < n))
                st.append(ss[j+increment - 2*i]);

            }
        }

        return st.toString();
        
    }
}