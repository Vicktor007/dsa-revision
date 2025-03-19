package easyQuestions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class TwoSumBST {
    /**
     Given the root of a binary search tree and an integer k, return true
     if there exist two elements in the BST such that their sum is equal to k,
     or false otherwise.
     */

//    Time o(n) space o(n)

    public boolean findTarget(TreeNode root, int k){
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<Integer> hashSet = new HashSet<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (hashSet.contains(k - node.val)){
                return true;
            }else {
                hashSet.add(node.val);

                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return false;

    }
}
