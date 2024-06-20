class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        int mask =1;
        for (int i = 0; i<=31;i++){
            if((n & mask) != 0) count ++;

            //Left shift the mask (mask <<= 1): This moves the mask one position to the left to check the next bit in the next iteration.

//n & mask = 00000000 00000000 00000000 00001011 & 00000000 00000000 00000000 00000001 = 00000000 00000000 00000000 00000001
// Since the result is not 0, increment count to 1.
// Left shift mask to 00000000 00000000 00000000 00000010.


            mask <<=1;
        }
        return count;
        }
    }