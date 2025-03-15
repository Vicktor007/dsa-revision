package MediumQuestions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /**
     Given an array of distinct integers, return all the possible permutations.
     You can return the answer in any order.
     */

    public List<List<Integer>> permute(int[] array){
//        list to store all possible permutations
        List<List<Integer>> result = new ArrayList<>();
//        Start the backtracking process 
        backtrack(result, new ArrayList<>(), array);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] array) {
//        Base case: If tempList contains all elements, it is a complete permutation
        if (tempList.size() == array.length){
//            add acopy of tempList to result
            result.add(new ArrayList<>(tempList));
            return;
        }
//        loop through all numbers in the input array
        for (int num :array){
//            Skip numbers alaedy in templist to avoid duplicates
            if (tempList.contains(num)) continue;
            tempList.add(num); //add number to the current permutation
//            recurse to continue building the permutation
            backtrack(result,tempList,array);
//            Remove the last number to back track
            tempList.remove(tempList.size()-1);
        }
    }
}
