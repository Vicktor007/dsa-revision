package MediumQuestions;

public class MinimumSizeArraySum {
    /**
     Given an array of positive integers nums and a positive integer target,
     return the minimal length of a subarray whose sum is greater than or equal to target,
     if there is no such subarray return 0 instead.
     */

    public int minimumArraySizeSum(int[] array, int target){
        int left =0;
        int total = 0;
        int result= Integer.MAX_VALUE;

        for (int right = 0; right< array.length; right++ ){
            total += array[right];

            while (total >= target){
                result = Math.min(result, right - left + 1);
                total -= array[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
