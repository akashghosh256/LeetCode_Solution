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
    String ans = "~";

    private String min(String a, String b){
        return a.compareTo(b) < 0 ? a:b;
    }

    void DFS(TreeNode root, String s){
        if( root == null) return;
        if( root.left == null && root.right == null){
            ans = min(ans, (char)('a'+ root.val)+s);
        }

        DFS(root.left, (char)('a'+ root.val)+s );
        DFS(root.right, (char)('a'+ root.val)+s);

    }

    public String smallestFromLeaf(TreeNode root) {
        DFS(root,"");
        return ans;

    }
}