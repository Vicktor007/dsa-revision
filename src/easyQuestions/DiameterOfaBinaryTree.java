package easyQuestions;

public class DiameterOfaBinaryTree {
    int diameter = 0;
    /**
      Diameter of Binary Tree
     Given the root of a binary tree, return the length of the diameter of the tree.
     The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
     This path may or may not pass through the root.
     The length of a path between two nodes is represented by the number of edges between them.
     */

    public int diameterOfBinaryTree(TreeNode root){
        calculateHeight(root);

        return diameter;

    }

    private int calculateHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDepth = calculateHeight(root.left);
        int rightDepth = calculateHeight(root.right);

        diameter = Math.max(diameter, leftDepth + rightDepth);

        return 1+Math.max(leftDepth,rightDepth);

    }
}
