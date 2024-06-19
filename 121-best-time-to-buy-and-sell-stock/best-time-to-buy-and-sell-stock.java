class Solution {
    public int maxProfit(int[] prices) {

        // buy low sell high man 
        // use two pointer
        int l = 0, r=0; // l= buy r= sell
        int n = prices.length;
        int maxP=0;
        while(r < n){
            if(prices[l] < prices[r]){
                int profit = prices[r] - prices[l];
                maxP = Math.max( maxP, profit);
                r++;
                
            }else{
                l=r;
                r++;

            }
        }

        return maxP;

        
    }
}