package easyQuestions;

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

public class AverageLevelinBinaryTree {
    /**
     Given the root of a binary tree, return the average value of the nodes
     on each level in the form of an array. Answers within 10^-5 of the actual
     answer will be accepted.
     */

    public List<Double> averageOfLevels(TreeNode root){
        List<Double> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;

            for (int i =  0; i<size; i++){
                TreeNode current = queue.poll();
                sum += current.val;

                if (current.left != null){
                    queue.offer(current.left);
                }
                if (current.right != null){
                    queue.offer(current.right);
                }
            }
            result.add(sum/size);
        }
        return result;
    }


}
