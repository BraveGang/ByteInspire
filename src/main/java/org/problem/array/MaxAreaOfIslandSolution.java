package org.problem.array;

/**
 * 岛屿的最大面积
 * （考察递归+搜索（深度优先搜索、广度优先搜索））
 * <p>
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
 * 你可以假设二维矩阵的四个边缘都被水包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 */
public class MaxAreaOfIslandSolution {

    public static void main(String[] args) {

    }

    /**
     * 深度优先搜索
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }

    /**
     * 递归遍历
     *
     * @param i
     * @param j
     * @param grid
     * @return
     */
    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(i + 1, j, grid);
        num += dfs(i - 1, j, grid);
        num += dfs(i, j + 1, grid);
        num += dfs(i, j - 1, grid);
        return num;
    }

    /**
     * 广度优先搜索
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland2(int[][] grid) {

        //TODO 自行去网上查找
        return 0;
    }

}
