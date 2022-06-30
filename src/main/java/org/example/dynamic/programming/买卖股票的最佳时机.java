package org.example.dynamic.programming;

public class 买卖股票的最佳时机 {

    /**
     * https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec?tpId=295&tqId=625&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
     * @param prices
     * @return
     */
    public int maxProfit (int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int len = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < len; i++){
            if (prices[i] < minPrice){
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {

    }
}
