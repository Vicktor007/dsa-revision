package MediumQuestions;

import java.util.Arrays;

public class DynamicProgramming {
    /**
     You are given an integer array coins representing coins of different denominations and
     an integer amount representing a total amount of money.
     Return the fewest number of coins that you need to make up that amount. If that amount
     of money cannot be made up by any combination of the coins, return -1.
     You may assume that you have an infinite number of each kind of coin.
     */
// time complexity 0(n*c) space complexity: 0(n)
    public int fewestNumberOfCoins(int[] array, int amount){

        int[] dynamicArray = new int[amount + 1];
        Arrays.fill(dynamicArray, amount + 1);
        dynamicArray[0] = 0;

        for (int i = 1; i<= amount; i++){
            for (int coin : array){
                if (i - coin>=0){
                    dynamicArray[i] = Math.min(dynamicArray[i],
                            dynamicArray[i - coin] + 1);
                }
            }
        }
        return dynamicArray[amount] > amount ? -1 : dynamicArray[amount];
    }
}
