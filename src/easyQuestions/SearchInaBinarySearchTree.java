package easyQuestions;

import java.util.ArrayList;
import java.util.List;

public class SearchInaBinarySearchTree {
    /**
     You are given the root of a binary search (BST) and an integer val.
     Find the node in the BST that the nodes value equals val and return the
     subtree rooted with that node. If such a node does not exist, return null.
     */

//    Space o(1) time 0(n)

    public TreeNode binarySearchTree(TreeNode root, int val){

        if (root == null || root.val == val){
            return root;
        }
        if (root.val > val){
            binarySearchTree(root.left, val);
        }

        return binarySearchTree(root.right, val);

    }

    public List<Integer> getChildren(TreeNode root, int val) {
        // Search for the node with the given value
        TreeNode targetNode = binarySearchTree(root, val);

        // If the node is found, return its children in a list
        if (targetNode != null) {
            List<Integer> children = new ArrayList<>();
            if (targetNode.left != null) {
                children.add(targetNode.left.val);
            }
            if (targetNode.right != null) {
                children.add(targetNode.right.val);
            }
            return children;
        }

        // If the node is not found, return an empty list
        return new ArrayList<>();
    }
}
