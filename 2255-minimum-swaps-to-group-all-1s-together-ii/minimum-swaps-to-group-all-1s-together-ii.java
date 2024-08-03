// class Solution {
//     public int minSwaps(int[] nums) {
    

//============================= sliding window =================================
// https://www.youtube.com/watch?v=t82KJaI1kNQ&t=60s&ab_channel=codestorywithMIK


//     int n = nums.length;
//     int  totalOne = 0;
//     int temp[] = new int[2*n];

//     for(int i=0; i<(2*n); i++){
//         temp[i] = nums[i%n];
//         if(i<n && nums[i] == 1) totalOne++;
//     }

//     int i=0;
//     int j=0;
//     int curOne = 0;
//     int maxOne = 0;

//     while(j< 2*n){
//         if(temp[j] == 1) curOne++;

//         // maintain window
//         if(j-i+1 > totalOne){
//             curOne -= temp[i];
//             i++;
//         }

//         maxOne = Math.max(maxOne, curOne);
//         j++;
//     }

//         return  totalOne - maxOne;




//     }
// }

// ========================= do with out temp array ==================

class Solution {
    public int minSwaps(int[] nums) {
    
    int n = nums.length;
    int  totalOne = 0;

    for(int i : nums)
    if( i == 1) totalOne++;
    

    int i=0;
    int j=0;
    int curOne = 0;
    int maxOne = 0;

    while(j< 2*n){


        if( nums[j%n] == 1) curOne++;

        // maintain window
        if(j-i+1 > totalOne){
            curOne -= nums[i%n];
            i++;
        }

        maxOne = Math.max(maxOne, curOne);
        j++;
    }

        return  totalOne - maxOne;




    }
}