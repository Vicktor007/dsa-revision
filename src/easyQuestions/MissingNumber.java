package easyQuestions;

import java.util.ArrayList;
import java.util.HashSet;

public class MissingNumber {

    /**
     Given an array nums containing n distnct number in the range (1, n),
     return the on;y number i the range that is missing from the array
     */

    public void missingNumber(int[] array){
        int n = array.length;

//        calculate the expected cum of numbers from 0 to n
        int expectedSum  = n*(n + 1) /2;

//        calculate the actual sum of the elements in the array
        int actualSum = 0;
        for (int number : array){
            actualSum+=number;
        }
//        return the difference between te expected sum and the actual sum
        System.out.println(expectedSum - actualSum);
    }

    private int findMissingNumber(int[] array){
//        find the length of the array which is n
      int   n= array.length;
//        find the expectedSum of numbers
        int expectedSum = n *(n+1) /2;
//        find the actualsum of numbers in the array
        int actualSum = 0;
        for (int number : array){
            actualSum+=number;
        }
//        return the missing number as the difference between the actual sum and the expected sum
        return expectedSum - actualSum;

    }

    /**
    given an array nums of n integer where nums[i] is in the range [1, n],
     return an array of all the integers in the range that do not appear in nums.
     */

    public ArrayList<Integer> findMissingNumbers(int[] array){

//        get the length of the array
        int n = array.length;
//        create the array to be returned
        ArrayList<Integer> returnArray = new ArrayList<>();
//       create a unique set for each of the numbers with hashset
        HashSet<Integer> set = new HashSet<>();
//      Add the numbers in the set
        for(int number : array){
            set.add(number);
        }
//       loop through the length of the array to find the numbers that are not present
        for (int i = 1; i<=n; i++ ){
            if(!set.contains(i)){
//                add the numbers that are not present in the array to be returned
                returnArray.add(i);
            }
        }
        for (int number : returnArray){
            System.out.print(number + " ");
        }
//        return the array with the numbers
        return returnArray;
    }
}
