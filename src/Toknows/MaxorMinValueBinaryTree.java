package Toknows;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left= null;
        this.right = null;
    }
}

public class MaxorMinValueBinaryTree {
    /**
     Find the minimum value in a binary tree.
     Find the maximum value in a binary tree.
     */

    public int minValue(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minNode = 0;

        while (!queue.isEmpty()){


                TreeNode currentNode = queue.poll();
                if (currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null){
                    queue.offer(currentNode.right);
                }

                if (currentNode.val < minNode){
                    minNode = currentNode.val;
                }


        }
        return minNode;
    }

    public int maxValue(TreeNode root) {
        if (root == null) {
            // Return Integer.MIN_VALUE if the tree is empty.
            return Integer.MIN_VALUE;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxNode = Integer.MIN_VALUE; // Initialize to smallest possible value.

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            // Update maxNode if the current node's value is greater.
            if (currentNode.val > maxNode) {
                maxNode = currentNode.val;
            }

            // Add left and right children to the queue if they exist.
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }

        return maxNode;
    }

}
