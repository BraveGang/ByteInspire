package org.problem.dynamic;

/**
 * 买卖股票的最佳时机
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 */
public class MaxProfitSolution {


    public static void main(String[] args) {

        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
        System.out.println(maxProfit2(nums));

    }

    /**
     * 暴力解法：两层循环遍历  时间复杂度n2
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0)
            return 0;
        int len = prices.length;
        int maxprofit = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                //如果第i天买入，依次判断它之后的每一天卖出的情况
                if (prices[j] - prices[i] > maxprofit)
                    maxprofit = prices[j] - prices[i];
            }
        }

        return maxprofit;
    }


    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {

        //解法二：动态规划法：用dp[i]表示第i天卖出的收益，
        //则dp[i]=max(price[i]-min,maxProfit)
        //时间复杂度：O(n),空间复杂度：O(1)
        if (prices == null || prices.length == 0)
            return 0;

        int len = prices.length;
        int maxprofit = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (prices[i] < min)  //维护一个最小值
                min = prices[i];
            else if (prices[i] - min > maxprofit)
                maxprofit = prices[i] - min;
        }

        return maxprofit;

    }


}
