package easyQuestions;

public class CountingBits {
    /**
     Given an integer n, return an array of length n +1 such that
     for each (0 <= i <= n), ans[i] is the number of 1s in th binary representation of i.
     */
// time complexity 0(n)
    public int[] countingBits(int n){
        int[] dp = new int[n +1];
        int offset = 1;

        for (int i = 1; i< n+1; i++){
            if (offset*2 == i){
                offset = i;
            }
            dp[i] = 1 + dp[i-offset];
        }
        return dp;
    }
}
