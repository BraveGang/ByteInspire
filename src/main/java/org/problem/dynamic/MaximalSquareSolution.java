package org.problem.dynamic;


/**
 * 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 */
public class MaximalSquareSolution {

    public static void main(String[] args) {

    }


    /**
     *
     * 解法-动态规划
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];

        int maxlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxlen = Math.max(maxlen, dp[i][j]);
                }

            }
        }

        return maxlen * maxlen;

    }


}
