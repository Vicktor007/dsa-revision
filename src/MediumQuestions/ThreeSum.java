package MediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]],
     such that i!=j, i!=k and j!=k, and nums[i]+nums[j]+nums[k]==0.
     Notice that the solution set must not contain duplicate triplets.
     */

    public List<List<Integer>> threeSum(int[] array){
        if (array[0]>=0){
            return new ArrayList<>();
        }
       List<List<Integer>> result = new ArrayList<>();
//        sort the array
        Arrays.sort(array);

        for (int i  = 0; i < array.length-2; i++){
//            test for duplicate elements for the first element and skip
            if (i> 0 && array[i] == array[i - 1] ){
                continue;
            }
//            start of two pointer technique
            int leftPointer = i + 1;
            int rightPointer = array.length-1;

            while (leftPointer < rightPointer){
                int sum = array[i] + array[leftPointer] + array[rightPointer];
//               if a triplet is found add it to the result array
                if (sum == 0){
                    result.add(Arrays.asList(array[i],array[leftPointer],array[rightPointer]));
                    leftPointer++;
                    rightPointer--;
//                  skip duplicate elements for the second and third elements
                    while (leftPointer < rightPointer && array[leftPointer] == array[leftPointer - 1]) {
                        leftPointer++;
                    }

                    while (leftPointer < rightPointer && array[rightPointer] ==array[rightPointer + 1]){
                        rightPointer--;
                    }

                }else if(sum<0){
//                    move left to increase the sum if less than zero
                    leftPointer++;
                }else {
//                    move right to decrease the sum if more than zero
                    rightPointer--;
                }
            }
        }
        return result;
    }
}
