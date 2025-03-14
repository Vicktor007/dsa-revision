package MediumQuestions;

public class LongestMountainInArray {
    /**
     You may recall that an array arr is a mountain array if and only if:
     arr.length >= 3
     There exists some index i (0-indexed) with 0 < i < arr.length - 1
     such that:
     arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
     arr[i] > arr[i+1] > ...> arr[arr.length - 1]

     Given an integer array arr, return the length of the longest subarray, which
     is a mountain.Return 0 if there is no mountain subarray.
     */

    public int longestMountainArray(int[][] array){
        int result = 0;
        int arrayCounter = 0;
        while (arrayCounter <= array.length){
            for (int[] subArray : array) {
                arrayCounter++;
                if (subArray.length >= 3 && subArray.length > result) {
                    result = subArray.length;
                }

            }
        }
        return result;
    }

    public class LongestMountain {
        public static int longestMountain(int[] arr) {
            if (arr.length < 3) {
                return 0; // A mountain must have at least 3 elements
            }

            int maxLength = 0;

            for (int i = 1; i < arr.length - 1; ) {
                // Check if current element is a peak
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    int left = i - 1;
                    int right = i + 1;

                    // Expand left
                    while (left > 0 && arr[left] > arr[left - 1]) {
                        left--;
                    }

                    // Expand right
                    while (right < arr.length - 1 && arr[right] > arr[right + 1]) {
                        right++;
                    }

                    // Calculate the length of the mountain
                    int length = right - left + 1;
                    maxLength = Math.max(maxLength, length);

                    // Move i to the end of the current mountain
                    i = right;
                } else {
                    // Move to the next element
                    i++;
                }
            }

            return maxLength;
        }


    }

    public int longestMountain2(int[] array){
        if (array.length < 3){
//            a mountain must have at least 3 values
            return 0;
        }

        int maxLength = 0;

        for (int i = 1; i < array.length - 1;){
//            check if current element is a peak
            if (array[i] > array[i - 1] && array[i] > array[i + 1]){
                int left = i -1;
                int right = i + 1;
//                expand left
                while (left>0 && array[left] > array[left - 1]){
                    left--;
                }

//                epand right
                while (right < array.length-1 && array[right] > array[right+1]){
                    right++;
                }
//                calculate the length of the mountain
                int length = right - left + 1;
                maxLength = Math.max(maxLength, length);

//                move i to the end of the current mountain;
                i = right;
            } else {
                i++;
            }
        }
        return maxLength;
    }

}
