package easyQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    /**  Given the root of a binary tree, return its maximum depth.
     A binary tree's maximum depth is the number of nodes along the
     longest path from the root node down to the farthest leaf node.
      */
    public int maxDepth(TreeNode root) {
        // If the root is null, the tree is empty, so depth is 0.
        if (root == null) {
            return 0;
        }

        // Use a queue for BFS.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;

        // Start BFS traversal.
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes at the current depth level.

            // Process all nodes at the current level.
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Add the left and right children (if they exist) to the queue.
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            // Increment depth after processing one level.
            depth++;
        }

        return depth;
    }

    public int maxDepthRecursive(TreeNode root) {
        // Base case: if the root is null, the depth is 0 (empty tree).
        if (root == null) {
            return 0;
        }

        // Recursively find the depth of the left and right subtrees.
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // The maximum depth is the greater of the two, plus 1 for the root node.
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
