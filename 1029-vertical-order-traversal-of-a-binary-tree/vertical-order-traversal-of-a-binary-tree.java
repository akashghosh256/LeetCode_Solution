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


class Tuple {
    TreeNode node;  // TreeNode representing the current node in the tree.
    int scale;      // Horizontal position or "x" coordinate of the node.
    int level;      // Vertical position or "y" coordinate of the node.

    public Tuple(TreeNode _node, int _scale, int _level) {
        node = _node;
        scale = _scale;
        level = _level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // TreeMap to store nodes by their horizontal position (scale).
        // The inner TreeMap stores nodes by their vertical position (level),
        // and PriorityQueue is used to maintain nodes within the same level.
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // Queue for level-order traversal of the tree.
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0)); // Start with the root node at (0,0).

        // Perform level-order traversal of the tree.
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.scale;  // Horizontal position.
            int y = tuple.level;  // Vertical position.

            // Create necessary data structures for the current horizontal position.
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }

            // Add the node value to the appropriate PriorityQueue.
            map.get(x).get(y).offer(node.val);

            // Enqueue left and right children for further traversal.
            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        // Prepare the final result list by flattening the TreeMap structure.
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }

        return list;  
    }
}
















