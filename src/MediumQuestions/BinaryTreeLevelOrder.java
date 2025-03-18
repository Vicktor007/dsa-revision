package MediumQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
public class BinaryTreeLevelOrder {
    /**
     Given the root of a binary tree, return the level order traversal of its nodes
     values.(i.e from left to right, level by level).
     */

    public List<List<Integer>> orderTraversal(TreeNode root){
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < queue.size(); i++){
                TreeNode node = queue.poll();

                level.add(node.val);

                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            lists.add(level);
        }
        return lists;
    }

    public List<List<Integer>> orderTraversal2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists; // Return an empty list if the tree is empty.
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Perform level order traversal using BFS.
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size(); // Get the number of nodes at the current level.

            // Traverse all nodes at the current level.
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // Remove the node from the queue.

                level.add(node.val); // Add the node's value to the current level.

                // Add the node's children to the queue for the next level.
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            lists.add(level); // Add the current level to the result.
        }

        return lists;
    }
}
