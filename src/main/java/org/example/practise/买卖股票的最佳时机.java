package org.example.practise;

public class 买卖股票的最佳时机 {


    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < minPrice){
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }


    public int maxProfit1(int[] prices) {
        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i-1]){
                totalProfit += prices[i] - prices[i-1];
            }
        }
        return totalProfit;
    }


    public static void main(String[] args) {

    }
}
