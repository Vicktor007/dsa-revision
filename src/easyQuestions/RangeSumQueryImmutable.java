package easyQuestions;

public class RangeSumQueryImmutable {
    /**
     Given an integer array nums, handle multiple queries of the following type:
     1. calculate the sum of the elements of nums between indices left and right
     inclusive where left <= right.
     implement the numArray class:
     . NumArray(int[] nums) initializes the object with the integer array nums.
     . int sumRange(int left, int right) Returns the sum of the elements of nums
     between indices left and right inclusive(i.e nums[left] + nums[left+1] + ... + nums[right]).
     */
//Time complexity : o(n)
    public class NumArray {
        private int[] accNums; // Array to store accumulated sums

        public NumArray(int[] nums) {
            accNums = new int[nums.length + 1]; // Initialize the accumulated sum array
            accNums[0] = 0; // Start with 0 for easier computation

            for (int i = 0; i < nums.length; i++) {
                accNums[i + 1] = accNums[i] + nums[i]; // Calculate accumulated sums
            }
        }

        public int sumRange(int left, int right) {
            return accNums[right + 1] - accNums[left]; // Compute range sum using accumulated sums
        }
    }

}
