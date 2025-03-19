package easyQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertSortedArrayToBinarySearchTree {

    /**
     Given an integer array nums where the elements are sorted in ascending order,
     convert it into a height-balanced binary search tree.
     */
//    time 0(n)

    public TreeNode sortedArrayToBST(int[] nums){

        if (nums == null || nums.length == 0){
            return null;
        }

        return convertToBST(nums, 0, nums.length-1);

    }

    private TreeNode convertToBST(int[] nums, int start, int end) {
        if (start > end){
            return null;
        }
//        choose the middle element as the root
        int mid = start+(end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);

//        Recursively build the left and right subtrees
        root.left = convertToBST(nums, start, mid-1);
        root.right = convertToBST(nums, mid +1, end);

        return root;
    }

}
