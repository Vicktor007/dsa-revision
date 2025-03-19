package easyQuestions;

public class MinimumAbsoluteDifferenceInBST {
    /**
     Given the root of a Binary Search tree, return the minimum absolute difference
     between the values of any two different nodes in the tree.
     */

    private int minDifference = Integer.MAX_VALUE;
    private TreeNode previousNode = null;

    public int getMinimumDifference(TreeNode root){
//        Perform an in order traversal to process nodes in sorted order
        inOrderTraversal(root);

        return minDifference;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root ==null){
            return;
        }

//        Traverse the left subtree
        inOrderTraversal(root.left);

        if (previousNode != null){
            minDifference = Math.min(minDifference, Math.abs(root.val - previousNode.val));
        }

        previousNode = root;

        inOrderTraversal(root.right);
    }


}
