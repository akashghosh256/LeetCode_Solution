// class Solution {
//     // public int findKthLargest(int[] nums, int k) {
//     //     Arrays.sort(nums);
//     //     return nums[nums.length - k ];
//     // }

//     public int findKthLargest(int[] nums, int k) {

//     final PriorityQueue<Integer> pq = new PriorityQueue<>();
//     for(int val : nums) {
//         pq.offer(val);

//         if(pq.size() > k) {
//             pq.poll();
//         }
//     }
//     return pq.peek();
// }
// }

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        int left = 0, right = nums.length - 1;
        int kth = 0;

        while (true) {
            int idx = partition(nums, left, right);
            if (idx == k - 1) {
                kth = nums[idx];
                break;
            }
            if (idx < k - 1) {
                left = idx + 1;
            } else {
                right = idx - 1;
            }
        }
        
        return kth;
    }

    // this is done to ignore any worst case 
    // if array gets already sorted theen finding pivot will make it little time taking so
    private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1, r = right;

        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot) {
                l++;
            }
            if (nums[r] <= pivot) {
                r--;
            }
        }

        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


// In the provided Java code, the worst-case time complexity for finding the kth largest element using the quickselect algorithm is 
// O(n^2), but with proper randomization of the pivot element, it can be reduced to an average-case time complexity of O(n).

// Worst-case scenario:
// The 
// worst-case scenario for the quickselect algorithm occurs when the selected pivot element consistently divides the array into very uneven subarrays, such 
// as when the pivot is always the smallest or largest element. This can happen, for example, if the input array is 
// already sorted in ascending or descending order, and you're trying to find the kth largest element.

// In this worst-case scenario, each recursive 
// call reduces the size of the array by only one element, leading to n recursive calls, each taking O(n) time. This 
// results in a worst-case time complexity of O(n^2).

// To mitigate the worst-case scenario, you can implement randomization when selecting the pivot element. 
// By randomly selecting the pivot, you greatly reduce the chances of consistently dividing the array unevenly, leading to an average-case time 
// complexity of O(n). This average-case behavior is what makes the quickselect algorithm efficient in practice. 