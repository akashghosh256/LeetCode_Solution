class Solution {

    private int count(int n){
        // Kernighan’s Algorithm
        int count =0;
        while(n>0){
             n = n & n-1;
             count++;
        }
        return count++;
    }


    public int[] countBits(int n) {

        // Kernighan’s Algorithm

        int ans[] = new int[n+1];
        for(int i=0; i<= n; i++){
            ans[i] = count(i);
        }

        return ans;

        
    }
}