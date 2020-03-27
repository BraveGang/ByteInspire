package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 动态和贪心
 */
public class DynamicAndGreedy {


    public static void main(String[] args) {

    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意你不能在买入股票前卖出股票。
     */

    //解法一：暴力解法：两层循环遍历  时间复杂度n2
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0)
            return 0;

        int len = prices.length;
        int maxprofit = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) { //如果第i天买入，依次判断它之后的每一天卖出的情况
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
    public int maxProfit2(int[] prices) {

        //解法二：动态规划法：用dp[i]表示第i天卖出的收益，则dp[i]=max(price[i]-min,maxProfit)
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

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */

    //贪心策略
    public int maxProfitTwo(int[] prices) {

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

    /**
     * 最大正方形
     * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
     */
    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];

        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;

    }

    /**
     * 给定一个整数 数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     */
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {

            if (sum > 0) {
                sum += nums[i];
            }

            if (sum <= 0) {
                sum = nums[i];
            }

            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }


    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     * 动态规划
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        int length = triangle.size();

        int[][] dp = new int[length + 1][length + 1];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];

    }

    /**
     * 俄罗斯套娃信封问题
     * <p>
     * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
     * <p>
     * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）
     */

    //排序 + 最长递增子序列
    public int maxEnvelopes(int[][] envelopes) {

        // sort on increasing in first dimension and decreasing in second
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });

        // extract the second dimension and run LIS
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i) secondDim[i] = envelopes[i][1];
        return lengthOfLIS(secondDim);


    }


    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }


}
