package MediumQuestions;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {
    /**
    Balance a Binary Search Tree

     Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.
      A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
     */

    public TreeNode balanceBST(TreeNode root){

        List<Integer> sortedValues = new ArrayList<>();
        inOrderTraversal(root, sortedValues);

        return buildBalancedBST(sortedValues, 0, sortedValues.size()-1);
    }

    private TreeNode buildBalancedBST(List<Integer> sortedValues, int start, int end) {
        if (start > end){
            return null;
        }

        int mid = start +(end - start)/2; //middle element as root
        TreeNode root = new TreeNode(sortedValues.get(mid));
        root.left = buildBalancedBST(sortedValues, start, mid - 1);
        root.right = buildBalancedBST(sortedValues, mid +1, end);

        return root;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> sortedValues) {
        if (root == null){
            return;
        }
        inOrderTraversal(root.left,sortedValues);
        sortedValues.add(root.val);
        inOrderTraversal(root.right,sortedValues);
    }


}
