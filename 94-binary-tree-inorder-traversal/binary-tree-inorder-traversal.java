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

// inorder - left - root - right

// public class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//     List<Integer> list = new ArrayList<Integer>();

//     Stack<TreeNode> stack = new Stack<TreeNode>();
//     TreeNode cur = root;

//     while(cur!=null || !stack.empty()){
//         while(cur!=null){
//             stack.add(cur);
//             cur = cur.left;
//         }
//         cur = stack.pop();
//         list.add(cur.val);
//         cur = cur.right;
//     }

//     return list;
// }
// }

// Time Complexity (TC): O(N)
// Space Complexity (SC): O(H)
// The space complexity is O(H), where H is the height of the binary tree.
// In the worst case, the function pushes all nodes from the root to the deepest leaf node onto the stack. The maximum number of nodes that can be on the stack at any given time is equal to the height of the tree.



import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorderRecursive(root, list);
        return list;
    }

    private void inorderRecursive(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        inorderRecursive(node.left, list);

        // Process the current node
        list.add(node.val);

        // Traverse the right subtree
        inorderRecursive(node.right, list);
    }
}







