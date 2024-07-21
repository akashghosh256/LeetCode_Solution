/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     long val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(long val) { this.val = val; }
 *     TreeNode(long val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return bst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

private boolean bst(TreeNode node, long min, long max){
    if(node == null) return true;
    if( node.val <= min || node.val>=max) return false;

    if(bst(node.left, min, node.val) && bst(node.right, node.val, max))
    return true;
    return false;
}
}