package easyQuestions;

import java.util.HashSet;

public class BitManipulation {
    /**
     Single number
     Given a non-empty array of integers,
     every element appears twice except for one.
     Find that single one.

     You must implement a solution with a linear runtime
     complexity and use only constant extra space.
     */

    public int findSingleNumber(int[] array){
        HashSet<Integer> hashSet = new HashSet<>();
        int result = 0;
        for (int i = 0; i < array.length; i++){
            if (!hashSet.contains(array[i])){
                hashSet.add(array[i]);
                result = array[i];
            }
        }
        return result;
    }

    public int bitManipulation(int[] array){
        int xor = 0;
        for (int i : array){
            xor^=i;
        }
        System.out.println(xor);
        return xor;
    }
}
