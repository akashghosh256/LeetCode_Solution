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
class Solution {
    int steps=0;

    int dfs(TreeNode node){
        if( node == null ) return 0;
        int leftReq = dfs(node.left);
        int rightReq = dfs(node.right);

        steps += Math.abs(leftReq) + Math.abs(rightReq);
        return (node.val - 1) + leftReq + rightReq;




    }


    public int distributeCoins(TreeNode root) {
     dfs(root);
     return steps;   
        
    }
}