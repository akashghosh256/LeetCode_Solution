/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == null || root == p || root == q) return root;

        // https://www.youtube.com/watch?v=Oi3_06ultic

       TreeNode left = lowestCommonAncestor(root.left,  p, q);
    TreeNode right = lowestCommonAncestor(root.right,  p, q);
    
     //  if found for from two left and right side  
         if(left != null && right != null) 
         return root;
    // both are in left 
         if(left != null) 
         return left;

// both are right 
         return right;
        



    }
}