package easyQuestions;

import java.util.Stack;

public class SameTree {
    /**
     Given the roots of two binary trees p and q, write a function to check if they are the same or not.
     Two binary trees are considered th same if they are structurally identical, and the nodes have the same value.
     */

    public boolean SameTree(TreeNode p, TreeNode q){

        Stack<TreeNode> stack = new Stack<>();

        stack.add(p);
        stack.add(q);

        while (!stack.isEmpty()){
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();

            if (node1 == null && node2 == null ){
                continue;
            } else if (node1 ==null || node2 == null || node1.val != node2.val){
                return false;
            }
            stack.add(node1.right);
            stack.add(node2.right);
            stack.add(node1.left);
            stack.add(node2.left);
        }
        return true;

    }
}
