package easyQuestions;

import java.util.Stack;

public class PathSum {
    /**
     Given the root of a binary tree and an integer target sum, return true if the given tree has a root
     to leaf path such that adding up all the values along the path equals targetSum.
     A leaf is a node with no children.
     */

    public boolean pathSum(TreeNode root, TreeNode targetSum){
        if (root == null){
            return false;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);
        stack.add(root.val);
        while (!stack.isEmpty()){
            TreeNode val = stack.pop();
            TreeNode current = stack.pop();

            if (current.left == null && current.right == null && val == targetSum){
                return true;
            }
            if (current.right != null){
                stack.add(current.right);
                stack.add(val+current.right.val);
            }
            if (current.left != null){
                stack.add(current.left);
                stack.add(current.left.val);
            }
        }
        return false;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Edge case: if the root is null, no path exists
        if (root == null) {
            return false;
        }

        // Use two stacks: one for nodes and one for the corresponding sum values
        Stack<TreeNode> stackNode = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();

        // Start with the root node and its value
        stackNode.push(root);
        stackSum.push(targetSum - root.val);

        while (!stackNode.isEmpty()) {
            TreeNode current = stackNode.pop();
            int currentSum = stackSum.pop();

            // Check if the current node is a leaf and the sum equals the target
            if (current.left == null && current.right == null && currentSum == 0) {
                return true;
            }

            // If there's a right child, push it onto the stack
            if (current.right != null) {
                stackNode.push(current.right);
                stackSum.push(currentSum - current.right.val);
            }

            // If there's a left child, push it onto the stack
            if (current.left != null) {
                stackNode.push(current.left);
                stackSum.push(currentSum - current.left.val);
            }
        }

        // If no path was found, return false
        return false;
    }

    public boolean hasPathSumRecursive(TreeNode root, int targetSum) {
        // Base case: if the root is null, there's no path, return false
        if (root == null) {
            return false;
        }

        // Check if the current node is a leaf and its value equals the targetSum
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Recursively check the left and right subtrees with the adjusted targetSum
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}
