class Solution {

    private int check(int ar[], double k){
        int th = 0;

        for(int i : ar){
             th += Math.ceil( i/k);
        }

        return th;

    }


    public int minEatingSpeed(int[] piles, int h) {
        

        // brute force - striver

        // Arrays.sort(piles);
        // int n = piles.length;
        // // maximum per hour we can eat this much bananas 
        // int max = piles[n-1];
        // int ans = 1;


        // // test all max eating 1 to max
        // for(int i =1; i<= max; i++){
        //     int  hour = check(piles, (double)i);
        //     if(  hour <= h ){
        //             ans = i;
        //             break;
        //     }
        // }

        // return ans;

        // binary search

        Arrays.sort(piles);
        int n = piles.length;
        // maximum per hour we can eat this much bananas 
        int max = piles[n-1];

        int low  = 1, high = max;
        int ans = Integer.MAX_VALUE;


        // test all max eating 1 to max
        // apply binary search
        while(low <= high){
            int mid = (low + high) / 2;
            int hours = check(piles, (double) mid);
            if( hours <= h){
                ans = Math.min(ans,mid);
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
     

        return ans;


    }
}