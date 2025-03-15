package MediumQuestions;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    /**
     Given an integer array nums of unique elements, return all
     possible subsets(the powerset).
     the solution set must not contain duplicate subsets. Return the solution in any order.
     */
    public List<List<Integer>> subSets(int[] array){
//         to store all subsets
        List<List<Integer>> result = new ArrayList<>();
//        start bactracking
        backtrack(0, array, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] array, List<Integer> current,List<List<Integer>> result){
//        add the current subset to the result list
        result.add(new ArrayList<>(current));

//        loop through the numbers to explore all subsets
        for (int i = start; i < array.length; i++){
//            include array[i] in the current subset
            current.add(array[i]);

//            Recursively build the subset with num[i] included
            backtrack(i + 1, array, current,result);

//            backtrack: remove the last element and explore the net possibility
            current.remove(current.size()-1);
        }
    }
}
