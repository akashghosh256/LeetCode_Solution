/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// class Solution {

//     void inorder(TreeNode root, List<Integer> nums){
//         if(root == null) return;

//         inorder(root.left,nums);
//         nums.add(root.val);
//         inorder(root.right,nums);
//     }



//     public boolean findTarget(TreeNode root, int k) {
//         List<Integer> nums = new ArrayList<>();
//         inorder(root,nums);
//         int i=0, j = nums.size() -1;
//         int  curSum =0;

//         while(i<j){
//             curSum = nums.get(i) + nums.get(j);
//             if(curSum == k) return true;
//             if(curSum < k) i++;
//             else if(curSum >k) j--;

//         }
//         return false;


//     }
// }

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> seen = new HashSet<>();
        return findSum(root, k, seen);
    }

    private boolean findSum(TreeNode root, int k, Set<Integer> seen) {
        if (root == null) {
            return false;
        }

        int complement = k - root.val;

        if (seen.contains(complement)) {
            return true;
        }

        seen.add(root.val);

        return findSum(root.left, k, seen) || findSum(root.right, k, seen);
    }
}













