package MediumQuestions;

import java.util.Stack;

public class KthSmallestElementInABST {
    /**
     Given the root of a binary search tree, and an integer k, return the kth smallest
     value (1-indexed) of all the values of the nodes in the tree.
     */
//Time =o(n) space= o(n)
    public int kthSmallestElementInABST(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            // Traverse left subtree
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            // If k is 0, we have found the kth smallest element
            if (k == 0) {
                return root.val;
            }
            // Move to right subtree
            root = root.right;
        }

        // If k is out of bounds, you may handle it with an exception or return a default value
        throw new IllegalArgumentException("k is out of range");
    }

}
