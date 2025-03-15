package easyQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    /**
     Given an array of distinct integersarr, find all pairs of elements
     within the minimum absolute difference of any two elements.

     Return a list odf pairs in ascending order (with resect to pairs), each pair
     [a,b] follows:
     a,b are from arr
     a<b
     b-a
     b-a equals to the minimum absolute difference of any two elements in arr
     */

    public ArrayList<Integer> minimumDifference(int[] array){
        Arrays.sort(array);
        float minimumDiff = 0;
        for (int i = 1; i<array.length;i++){
            minimumDiff = Math.min(minimumDiff, array[i] -array[i - 1]);

        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i<array.length;i++){
            if (array[i] - array[i-1] == minimumDiff){
                result.add(array[i-1],array[i]);
            }
        }
        return result;
    }



    public class MinimumAbsDifference {
        public static List<List<Integer>> minimumAbsDifference(int[] arr) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(arr); // Step 1: Sort the array

            int minDifference = Integer.MAX_VALUE;

            // Step 2: Find the minimum absolute difference
            for (int i = 1; i < arr.length; i++) {
                int diff = arr[i] - arr[i - 1];
                if (diff < minDifference) {
                    minDifference = diff;
                }
            }

            // Step 3: Gather all pairs with the minimum absolute difference
            for (int i = 1; i < arr.length; i++) {
                int diff = arr[i] - arr[i - 1];
                if (diff == minDifference) {
                    result.add(Arrays.asList(arr[i - 1], arr[i]));
                }
            }

            return result;
        }

        public static void main(String[] args) {
            int[] arr = {4, 2, 1, 3};
            System.out.println(minimumAbsDifference(arr)); // Output: [[1, 2], [2, 3], [3, 4]]
        }
    }

}
