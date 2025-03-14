package easyQuestions;

public class SquaresOfaSortedArray {
    /**
     Given an integer array nms sorted in non-decreasing order,
     return an array of the squares of each number in non-decreasing order.
     */

    public int[] squaresOfaSortedArray(int[] sortedArray){
        if (sortedArray.length == 0)
            return new int[]{};

        int[] squaredArray = new int[sortedArray.length];

        for (int i = 0; i< sortedArray.length; i++){
            squaredArray[i] = sortedArray[i] * sortedArray[i];
        }
        for (int i : squaredArray){
            System.out.print(i + " ");
        }
        return squaredArray;
    }

    public int[] squaresOfaSortedArray2(int[] array) {
//        check if the array is empty and return an empty array
        if (array.length == 0) {
            return new int[]{};
        }
//        initialize the array to contain the squared values with the initial array length
        int[] squaredArray = new int[array.length];
//first algorithm: check if the array contains negative numbers to execute the correct algorithm
        if (array[0] > 0) {

//            loop through the array

            for (int i = 0; i < array.length; i++) {
//                insert the squared value in the corresponding index
                squaredArray[i] = array[i] * array[i];
            }

        } else {


            int left = 0, right = array.length - 1;
            int index = array.length - 1;
            while (left <= right) {
                int leftSquare = array[left] * array[left];
                int rightSquare = array[right] * array[right];

                if (leftSquare > rightSquare) {
                    squaredArray[index] = leftSquare;
                    left++;
                } else {
                    squaredArray[index] = rightSquare;
                    right--;
                }
                index--;
            }
        }

        for (int i : squaredArray) {
            System.out.print(i + " ");
        }
        return squaredArray;

    }
}
