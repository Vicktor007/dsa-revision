package easyQuestions;

import java.util.HashMap;

/**
 Given an array of integers nums and an integer target,
 return indices of the two numbers such that they add up to target.
 You may assume that each input would have exactly one solution, and
 you may not use the same element twice.
 */

public class SumOfTwoNumbers {

    public int[] sumOfTwoNumbers(int[] array, int target) {
        HashMap<Integer, Integer> container = new HashMap<>();

        for (int index = 0; index < array.length; index++) {
            int value = array[index];
            int difference = target - value;

//           check if the difference already exist in the container
            if (container.containsKey(difference)) {
//                returns an array containing the current index and
//                the difference index if found in the container
                return new int[]{index, container.get(difference)};
            }
//            Adds the difference to the container if it doesn't have it
            container.put(value, index);
        }
//        return an empty array if no solution is found
        return new int[]{};
    }

    public int[] twoSum(int[] array, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int index = 0; index < array.length; index++) {
            int value = array[index];
            int difference = target - value;

            if (hashMap.containsKey(difference)) {
                return new int[]{index, hashMap.get(difference)};
            }
            hashMap.put(value, index);
        }
        return new int[]{};
    }

    public int finalValueAfterOperations(String[] operations) {
        int val = 0; // Starting value
        for (int i = 0; i < operations.length; i++) { // Fix loop initialization and condition
            if (operations[i].charAt(1) == '+') { // Check the second character
                val++;
            } else {
                val--;
            }
        }
        return val; // Return the final value
    }


}