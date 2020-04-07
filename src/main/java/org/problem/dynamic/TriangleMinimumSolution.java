package org.problem.dynamic;

import java.util.List;

/**
 * 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 动态规划
 */
public class TriangleMinimumSolution {


    public static void main(String[] args) {

    }

    /**
     * 自底向上思想 + 动态规划
     * @param triangle
     * @return
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

}
