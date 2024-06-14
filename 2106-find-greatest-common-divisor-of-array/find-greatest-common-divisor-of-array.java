// class Solution {
//     public int findGCD(int[] nums) {
//         Arrays.sort(nums);
//         int gcd = 1;
//         int n = nums.length;
//         for(int i=1; i<=nums[0];i++){
//             if(nums[n-1]%i == 0 && nums[0]%i == 0)
//             gcd = i;

//         }
//         return gcd;
        
//     }
// }


class Solution {

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        return gcd(nums[0], nums[n-1]);
    }
}