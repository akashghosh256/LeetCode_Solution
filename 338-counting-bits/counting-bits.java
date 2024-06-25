class Solution {

    private int count(int n){
        // Kernighan’s Algorithm =  log n
        int count =0;
        while(n>0){
             n = n & n-1;
             count++;
        }
        return count++;
    }


    public int[] countBits(int n) {

        // better Kernighan’s Algorithm o(n log n)

        // int ans[] = new int[n+1];
        // for(int i=0; i<= n; i++){
        //     ans[i] = count(i);
        // }

        // return ans;



        // using dp ayushi 

        int ans[] = new int[n+1];

        ans[0] = 0;

        for(int i=1; i<=n ; i++){
            if( i % 2 == 0)
            ans[i] = ans[i/2];
            else ans[i] = ans[i/2]+1;
        }
        
        return ans;

    

        
    }
}