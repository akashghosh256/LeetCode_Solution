import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private void markParents(TreeNode node, Map<TreeNode, TreeNode> parent) {
        if (node == null) return;

        if (node.left != null) {
            parent.put(node.left, node);
            markParents(node.left, parent);
        }

        if (node.right != null) {
            parent.put(node.right, node);
            markParents(node.right, parent);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // For storing parent details and making an undirected graph
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParents(root, parent);
        
        Map<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        vis.put(target, true);

        int curLevel = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (curLevel++ == k) break;

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                if (cur.left != null && !vis.containsKey(cur.left)) {
                    q.add(cur.left);
                    vis.put(cur.left, true);
                }

                if (cur.right != null && !vis.containsKey(cur.right)) {
                    q.add(cur.right);
                    vis.put(cur.right, true);
                }

                if (parent.containsKey(cur) && !vis.containsKey(parent.get(cur))) {
                    q.add(parent.get(cur));
                    vis.put(parent.get(cur), true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            result.add(cur.val);
        }

        return result;
    }
}
