package org.problem;

/**
 * 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class MaxProfitIISolution {


    public static void main(String[] args) {

        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfitII(nums));

    }

    /**
     * 贪心策略
     *
     * @param prices
     * @return
     */
    public static int maxProfitII(int[] prices) {

        if (prices == null || prices.length == 0)
            return 0;
        int len = prices.length;
        int profit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1])
                profit += (prices[i] - prices[i - 1]);
        }
        return profit;
    }


}
