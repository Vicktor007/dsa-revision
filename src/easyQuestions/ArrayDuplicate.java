package easyQuestions;

import java.util.HashSet;

public class ArrayDuplicate {


    /**
    Question
    Given an integer array nums, return true if any value appears at least twice in the array
     and return false if every element is distinct
     */


    public boolean containsDuplicate(int[] givenArray){
// use a hashset to check for duplicates
        HashSet<Integer> set = new HashSet<>();
//
//        Add elements and check for duplicates
        for (int number : givenArray){
            if (!set.add(number)){
//                i add() returns false, it means the element already exists
                return true;
            }

        }
//       returns false if no duplicates found
    return false;
    }


    public boolean duplicate2(int[] givenArray){
//        Create a set to check for duplicates
        HashSet<Integer> set = new HashSet<>();


//        Add elements to the hashset and check for duplicates
        for (int numbers : givenArray){
            if (!set.add(numbers)){
//            if add() returns false, it means the element already exists

                return true;

            }
        }
//        no duplicates found
        return false;
    }
}
