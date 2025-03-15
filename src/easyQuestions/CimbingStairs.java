package easyQuestions;

public class CimbingStairs {
    /**
     Yor are climbing a staircase. It takes n steps to reach the top.
     Each time you can either climb 1 or 2 steps.
     In how many distinct ways can you climb to the top.
     */

    public int twoSteps(int steps){

        int[] dynamicArray = new int[steps + 1];
        dynamicArray[0] = 0;
        dynamicArray[1] = 1;
        dynamicArray[2] = 2;

        for (int i = 3; i < steps + 1; i++){
            dynamicArray[i] = dynamicArray[i-1] + dynamicArray[i-2];
        }
        return dynamicArray.length;
    }
// time and space complexity = 0(n)
    public int twoSteps2(int steps) {
        // Edge case: If there are 0 or 1 steps, return the number of steps directly
        if (steps == 0) return 0;
        if (steps == 1) return 1;

        // Create the DP array
        int[] dynamicArray = new int[steps + 1];
        dynamicArray[0] = 1; // 1 way to climb 0 steps
        dynamicArray[1] = 1; // 1 way to climb 1 step
        dynamicArray[2] = 2; // 2 ways to climb 2 steps (1+1, 2)

        // Fill the array for all steps >= 3
        for (int i = 3; i <= steps; i++) {
            dynamicArray[i] = dynamicArray[i - 1] + dynamicArray[i - 2];
        }

    // Return the result for 'steps'
        return dynamicArray[steps];
}
}
