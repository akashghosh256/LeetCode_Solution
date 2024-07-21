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
class BSTIterator {
    List<Integer> ans;
    int pointer;

    void inorder(TreeNode node){
        if(node  == null) return;
        inorder(node.left);
        ans.add(node.val);
        inorder(node.right);
    }

    public BSTIterator(TreeNode root) {
        ans = new ArrayList<>();
        pointer = -1;
        inorder(root);
        
    }
    
    public int next() {
        return ans.get(++pointer);
        
    }
    
    public boolean hasNext() {
        return pointer + 1 < ans.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */