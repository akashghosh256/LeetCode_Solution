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
 // Postorder - left - right - root


 
// class Solution {
// public List<Integer> postorderTraversal(TreeNode root) {
//     List<Integer> list = new ArrayList<>();
//     if(root == null) return list;
//     Stack<TreeNode> stack = new Stack<>();
//     stack.push(root);
//     while(!stack.empty()){
//         root = stack.pop();

//         list.add(0, root.val);    // it is inserting the value at the front of the list, which effectively reverses the order of elements in the list.
// //when you add a new element at index 0, it shifts all existing elements in the list to the right by one position. In other words, the element that was previously at index 0 is moved to index 1, the element at index 1 is moved to index 2, and so on. This makes room for the new element at index 0.


//         if(root.left != null) stack.push(root.left);
//         if(root.right != null) stack.push(root.right);
//     }
//     return list;
// }
// }


import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            list.addFirst(root.val); // Add to the beginning of the list
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
        return list;
    }
}
