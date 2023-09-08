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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();

            // Traverse all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // If it's the last node at this level, add it to the result
                if (i == size - 1) {
                    res.add(node.val);
                }

                // Add child nodes to the queue
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return res;
    }
}