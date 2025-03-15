package MediumQuestions;

public class MaximumSubArray {
/**
  Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */

public int maximumSubArray(int[] array){

    int sum = Integer.MIN_VALUE;

    for (int j : array) {


            sum += j;
        }



    return sum;
}

public  int maxSub(int[] array){
    int maxSum = array[0];
    int currentSum = 0;

    for(int i : array){
        if (currentSum <0){
            currentSum = 0;
        }
        currentSum+=i;
        maxSum = Math.max(maxSum, currentSum);

    }
    return maxSum;
}
//    Kadane's Algorithm.
//    time complexity o(n)
public int maxSubArray(int[] arr) {
    // Edge case: If the array is empty
    if (arr == null || arr.length == 0) {
        throw new IllegalArgumentException("Array cannot be null or empty");
    }

    // Initialize variables
    int currentMax = arr[0];  // Maximum sum ending at the current position
    int globalMax = arr[0];   // Overall maximum sum

    // Iterate through the array
    for (int i = 1; i < arr.length; i++) {
        // Update currentMax to include the current element, or start fresh from the current element
        currentMax = Math.max(arr[i], currentMax + arr[i]);

        // Update globalMax if the currentMax is greater
        globalMax = Math.max(globalMax, currentMax);
    }

    return globalMax; // Return the maximum subarray sum
}
}
