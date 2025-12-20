package org.example.algorithm;

//    121. 买卖股票的最佳时机
//    如果第i天卖出股票，则最大利润为(该天的股价-前面天数中最小的股价)，然后与已知的最大利润比较，如果大于则更新当前最大利润的值。
public class TheBestTimeToBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < length; i++) {
            cost = Math.min(cost, prices[i]);
            profit = Math.max(profit, prices[i] - cost);
        }
        return profit;
    }

}
