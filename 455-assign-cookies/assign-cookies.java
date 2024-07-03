class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        int count =0;
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int l=0, r=0;


        while(l < n && r < m){

            if(g[l] <= s[r]){
                count++;
                l++;
             
                // System.out.println(g[l]);
                //  System.out.println(s[r]);


            }
            r++;

        }
        return count;



    }
}