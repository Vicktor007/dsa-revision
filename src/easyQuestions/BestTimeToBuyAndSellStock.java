package easyQuestions;

public class BestTimeToBuyAndSellStock {
    /**
     You are given an array prices, where prices[i] is the price of a given
     stock on the ith day.
     You want to maximize your profit by choosing a single day
     to buy one stock and choosing a different day to sell that stock.
     Return the maximum profit you can achieve from this transaction,
     if you cannot achieve any profit, return 0.
     */

    public int maxProfit(int[] prices){

        if (prices == null || prices.length < 2) {
            return 0;
        }
//        initialize left, right pointers and maxprofit
        int left = 0, right = 1;

        int maxProfit = 0;
        while (right != prices.length){
            if (prices[left] < prices[right]){
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left = right;
            }
            right+=1;
        }
        System.out.println(maxProfit);
        return maxProfit;
    }
}
