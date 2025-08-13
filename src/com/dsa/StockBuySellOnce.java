/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
package com.dsa;

public class StockBuySellOnce {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Maximum Profit - " + findMaxProfit(prices));
    }

    private static int findMaxProfit(int[] prices) {
        int minPrice = prices[0], maxProfit = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
