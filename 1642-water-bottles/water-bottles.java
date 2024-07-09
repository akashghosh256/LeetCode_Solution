// class Solution {
//     public int numWaterBottles(int numBottles, int numExchange) {
        
//         int nB = numBottles;
//         int ans = numBottles;

//         while(nB >= numExchange){
            
//             int newBottles = (int)nB/ numExchange;
//             int remBottles = (int)nB % numExchange;
//             ans += newBottles;
//             nB = newBottles + remBottles; 

//         }

//         return ans;


//     }
// }


class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
    
    return numBottles + (numBottles -1) / (numExchange-1);




    }
}