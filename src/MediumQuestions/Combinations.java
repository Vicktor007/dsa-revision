package MediumQuestions;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    /**
     Given two integers n and k, return all possible combinations of k numbers
     chosen from the range [1,n]
     You may return the answer in any order
     */
    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k ){
        if (tempList.size() ==k){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i<= n; i++){
            tempList.add(i);
            backtrack(result,tempList, i+1, n, k);
            tempList.remove(tempList.size()-1);
        }
    }
}
// 0(k*n!/k!(n-k!)

