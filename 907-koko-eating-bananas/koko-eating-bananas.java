class Solution {

    private int check(int piles[], double hr){
        int hours = 0;
        for(int i : piles){
            hours += Math.ceil(i/hr);
        }
        return hours;


    }



    public int minEatingSpeed(int[] piles, int h) {
        // Accenture
        int n = piles.length;
        Arrays.sort(piles);

        // range of eating 
        int low = 1;
        int high = piles[n-1];

        int ans = Integer.MAX_VALUE;
        while(low <= high){

            int mid = ( low + high ) / 2;
            int hours = check(piles, (double)mid);
            if(hours <=h){
                ans = Math.min(ans, mid);
                high = mid - 1;
            }
            else low = mid + 1;






        }

        return ans;

    }
}