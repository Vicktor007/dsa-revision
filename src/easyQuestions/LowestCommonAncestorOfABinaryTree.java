package easyQuestions;

public class LowestCommonAncestorOfABinaryTree {
    /**
      Lowest Common Ancestor of a Binary Tree
     Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself)."
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null, or root is either p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recur for the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides return non-null, this means p and q are found in different subtrees
        // Hence, root is their LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null child (either left or right)
        return left != null ? left : right;
    }
}
