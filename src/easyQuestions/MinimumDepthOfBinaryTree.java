package easyQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    /**
     * Given a binary tree, find its minimum depth.
     * The minimum depth is the number of node along the shortest path
     * from the root node down to the nearest leaf node.
     * <p>
     * Note: a leaf is a node with no children.
     */


    public int minDepth(TreeNode root) {
        // If the root is null, the tree is empty, so the minimum depth is 0.
        if (root == null) {
            return 0;
        }

        // Use a queue for a Breadth-First Search (BFS).
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Track the depth of the tree.
        int depth = 1;

        // Start BFS traversal.
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all nodes at the current depth level.
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Check if the current node is a leaf node.
                if (current.left == null && current.right == null) {
                    return depth; // Return the depth when the first leaf is found.
                }

                // Add the left child to the queue if it exists.
                if (current.left != null) {
                    queue.offer(current.left);
                }

                // Add the right child to the queue if it exists.
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            // Increment depth as we move to the next level.
            depth++;
        }

        return depth; // This line is just a fallback (it should never be reached).
    }
}

