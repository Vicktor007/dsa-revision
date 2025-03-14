package easyQuestions;

import java.util.Arrays;
import java.util.HashMap;

public class SmallerNumbersThanCurrentNumber {

/**
 Given the array nums,for each nums[i],
 find out how many numbers in the array are smaller that it.
 That is, for each  nums[i],
 you have to count the number of valid js',
 such that j != i and nums[j] < nums[i].
 return the answer  in an array
 */

public int[] smallerNumbers(int[] array){
//    step 1: create a sorted copy of the array
    int[] temporaryArray = array.clone();
//    sort the cloned array
    Arrays.sort(temporaryArray);
//    Step two: create a Hashmap to map each number
//    to its index in the sorted array
//    which also serve as the number of smaller elements it has in the array
    HashMap<Integer,Integer> indexMap = new HashMap<>();
    for (int i = 0; i < temporaryArray.length; i++){
        if (!indexMap.containsKey(temporaryArray[i])){
//            map the number to it index in the sorted array
            indexMap.put(temporaryArray[i], i);
        }
    }

//  Step 3: Build the result array using the index mapping
int[] returnArray = new int[array.length];
    for (int i = 0; i< array.length; i++){
//        use the mapping to get the index of each number
        returnArray[i] = indexMap.get(array[i]);
    }
// return the result
    return returnArray;
}

public  int[] smallerNumbersSum(int[] array){
    int[] temporaryArray= array.clone();

    Arrays.sort(temporaryArray);
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i< temporaryArray.length;i++){
        if(!indexMap.containsKey(temporaryArray[i])){
            indexMap.put(temporaryArray[i],i);
        }


    }
    int[] returnArray = new int[array.length];
    for (int i = 0; i< array.length; i++ ){
        returnArray[i] = indexMap.get(array[i]);
    }
    return returnArray;
}
}
