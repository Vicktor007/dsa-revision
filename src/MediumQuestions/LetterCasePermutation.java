package MediumQuestions;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    /**
     Given a string s, you can transform every letter individually to e lowercase or
     uppercase to create another string
     Return a list of all possible strings we could create. Return the output in any order.
     */
    public List<String> letterCasePermutation(String s){
//        to store all permutations
        List<String> result = new ArrayList<>();
        bactrack(s.toCharArray(), 0 , result);
        return result;
    }

    private void bactrack(char[] chars, int index, List<String> result){
//        Base case: if we've processed all characters, add the current permutation
        if (index == chars.length){
            result.add(new String(chars));
            return;
        }

//        recursive case
//        If the current character is a letter, try both lowercase and uppercase
        if (Character.isLetter(chars[index])){
//            try lowercase
            chars[index] = Character.toLowerCase(chars[index]);
            bactrack(chars,index + 1, result);
//            Try uppercase
            chars[index] = Character.toUpperCase(chars[index]);
            bactrack(chars, index + 1, result);
        } else {
//            if its not a letter, just move to the next character
            bactrack(chars,index+1, result);
        }
    }
}
