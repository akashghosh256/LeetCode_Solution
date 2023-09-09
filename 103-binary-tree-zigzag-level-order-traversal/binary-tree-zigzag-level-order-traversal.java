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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
          List<List<Integer>> result = new ArrayList();
        if(root == null)
            return result;
        
        Queue<TreeNode> que = new LinkedList();
        que.add(root);
        int lev = 1;
        
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
            if ((lev & 1) == 0){
                Collections.reverse(level);
                result.add(level);
            }
            else result.add(level);

            lev++;
        }
        return result;
    }
    
}