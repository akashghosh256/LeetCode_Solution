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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null)
            return result;
        
        Queue<TreeNode> que = new LinkedList();
        que.add(root);
        
        while(!que.isEmpty()){

            int size = que.size();  // queue will store the no. of elements according to level
            List<Integer> level = new ArrayList();

            while(size>0){
                TreeNode node = que.poll();
                level.add(node.val);
                if(node.left != null)
                    que.add(node.left);
                if(node.right != null)
                    que.add(node.right);
                size--;
            }
            result.add(level);
        }
        return result;
    }
}

// TC - O(N)  SC - O(N)