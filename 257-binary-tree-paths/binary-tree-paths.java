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

    private void helper(List<String> res, TreeNode root, StringBuilder sb ){
        if( root == null) return;
        int len = sb.length();
        sb.append(root.val);

        if( root.left == null && root.right == null){
            res.add(sb.toString());
        }
        else{
          sb.append("->");
          helper(res, root.left, sb);
          helper(res, root.right, sb);

         }
         // Restore the StringBuilder to its previous state by setting its length.
         sb.setLength(len);

    }



    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res,root, sb);
        return res;
    }
}