package easyQuestions;

public class InvertBinaryTree {
    /**
     Given the root of a binary tree,invert the tree and return its root.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            // Temporarily store the left subtree
            TreeNode temp = root.left;

            // Swap the left and right subtrees
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
        }

        return root;
    }


}


