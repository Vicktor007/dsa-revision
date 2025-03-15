package easyQuestions;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate2 {
    /**
     Given an integer array nums and an integer k, return true if there are two
     distinct indices i and j in the array such that nums[i] == nums[j]
     and abs(i-j)<= k.
     */

    public boolean containsDuplicate(int[] array, int anInt){
        HashSet<Integer> seenSet = new HashSet<>();
        for (int i : array){
            if (!seenSet.add(i)){
                return true;
            }
            if (seenSet.size() > anInt){
                seenSet.remove(i - anInt);
            }
        }
        return false;
    }

    public class ContainsDuplicate {
        /**
         Given an integer array nums and an integer k, return true if there are two
         distinct indices i and j in the array such that nums[i] == nums[j]
         and abs(i-j)<= k.
         */
        public boolean containsDuplicate(int[] array, int anInt) {
            HashSet<Integer> seenSet = new HashSet<>();
            for (int i = 0; i < array.length; i++) { // Iterate with index
                if (!seenSet.add(array[i])) { // If unable to add, duplicate exists
                    return true;
                }
                if (seenSet.size() > anInt) { // Maintain the sliding window
                    seenSet.remove(array[i - anInt]); // Remove the oldest element
                }
            }
            return false;
        }
    }


    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // To store elements and their last index

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                // Check if the difference between indices is less than or equal to k
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            // Update the index of the current element
            map.put(nums[i], i);
        }

        return false; // No such pair found
    }


}






