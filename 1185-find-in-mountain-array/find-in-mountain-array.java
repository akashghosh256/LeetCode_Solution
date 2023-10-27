/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left =0 , right = mountainArr.length()-1;
      //  System.out.println(right);

      int peak=0;


// finding peak element using binary search
      while(left<= right){
          int mid = ( left+ right) /2 ;
          if( mountainArr.get(mid) >= mountainArr.get(mid +1))
          right = mid -1;
          else left = mid + 1;
   }

peak = left;

// finding the target in first half

int l = 0, r = peak;
    while (l <= r) {
            int mid = (l + r) / 2;
            int cur = mountainArr.get(mid);
            if (cur == target) {
                return mid;
            } else if (cur > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }


// else try finding the target in next half of peak element
 l = peak + 1;
        r = mountainArr.length() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int cur = mountainArr.get(mid);
            if (cur == target) {
                return mid;
            } else if (cur > target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }


        return -1;

        
    }
}