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

// preorder - root - left - right

// public class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         Stack<TreeNode> stack = new Stack<>();
//         List<Integer> list = new ArrayList<>();
//         TreeNode cur = root;
//         while(!stack.isEmpty() || cur != null){
//             while(cur != null){
//                 list.add(cur.val);
//                 stack.push(cur);
//                 cur = cur.left;
//             }
//             cur = stack.pop();
//             cur = cur.right;
//         }
//         return list;
//     }
// }


// Recursive Approach

// import java.util.ArrayList;
// import java.util.List;

// public class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<Integer>();
//         preorderRecursive(root, list);
//         return list;
//     }

//     private void preorderRecursive(TreeNode node, List<Integer> list) {
//         if (node == null) {
//             return;
//         }

//         // Process the current node
//         list.add(node.val);

//         // Recursively traverse the left subtree
//         preorderRecursive(node.left, list);

//         // Recursively traverse the right subtree
//         preorderRecursive(node.right, list);
//     }
// }




import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                // Process the current node before moving to the right subtree
                ans.add(current.val);
                current = current.right;
            } else {
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                if (pre.right == null) {
                    // Process the current node before traversing the left subtree
                    ans.add(current.val);  // change is here
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    //ans.add(current.val);  // change is here
                    current = current.right;
                }
            }
        }
        return ans;
    }
}












