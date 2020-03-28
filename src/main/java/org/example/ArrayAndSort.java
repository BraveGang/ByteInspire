package org.example;

import org.example.sort.MergeSortSolution;

import java.util.*;

/**
 * 数组和排序
 */
public class ArrayAndSort {

    public static void main(String[] args) {

        //数组和排序
    }

    /**
     * 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     */
    //求三数之和：暴力解法
    private List<List<Integer>> directlySolution(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> value = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(value);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }


    //求三数之和： 夹逼法
    private List<List<Integer>> squeezeSolution(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }

        Set<List<Integer>> result = new LinkedHashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            int head = i + 1;
            int tail = nums.length - 1;

            while (head < tail) {

                int sum = -(nums[head] + nums[tail]);
                if (sum == nums[i]) {
                    List<Integer> value = Arrays.asList(nums[i], nums[head], nums[tail]);
                    result.add(value);
                }

                if (sum <= nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }
        }

        return new ArrayList<>(result);
    }


    /**
     * 三数之和：夹逼法快速版
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> squeezeFastSolution(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // 加速1：c为非负数，就不能满足a+b+c=0了
            if (nums[i] > 0) {
                return result;
            }

            // 加速2：跳过计算过的数据，同时防止结果重复
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = -(nums[head] + nums[tail]);
                if (sum == nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    // 加速3：跳过计算过的数据，同时防止结果重复
                    while (head < tail && nums[head] == nums[head + 1]) {
                        head++;
                    }
                    while (head < tail && nums[tail] == nums[tail - 1]) {
                        tail--;
                    }
                }

                if (sum <= nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }

        }

        return result;
    }

    /**
     * 岛屿的最大面积
     * <p>
     * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
     * 你可以假设二维矩阵的四个边缘都被水包围着。
     * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
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
     * 搜索旋转排序数组
     * <p>
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * 你可以假设数组中不存在重复的元素。
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * <p>
     * 考察-二分查找
     */
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;

        while (left <= right) {

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {  //左边升序
                if (target >= nums[left] && target <= nums[mid]) {//在左边范围内
                    right = mid - 1;
                } else {//只能从右边找
                    left = mid + 1;
                }

            } else { //右边升序
                if (target >= nums[mid] && target <= nums[right]) {//在右边范围内
                    left = mid + 1;
                } else {//只能从左边找
                    right = mid - 1;
                }

            }

            mid = left + (right - left) / 2;
        }

        return -1;  //没找到
    }

    /**
     * 最长连续递增序列
     * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
     */
    public int findLengthOfLCIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i - 1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }

        return ans;

    }

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    /**
     * 数组中的第K个最大元素
     * <p>
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 先对数组进行降序排列  然后取下标k-1
     */
    public int findKthLargest(int[] nums, int k) {
        // 先对数组进行降序排列
        int[] newNum = MergeSortSolution.mergeSortDesc(nums, 0, nums.length - 1);
        // 返回第K个最大值（下标k-1）
        return newNum[k - 1];

    }

    /**
     * 最长连续序列
     * <p>
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     * 要求算法的时间复杂度为 O(n)。
     */

    public int longestConsecutive(int[] nums) {

        int max = 0;
        int count = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }

        max = Math.max(count, max);

        return max;

    }

    /**
     * 第k个排列
     * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
     */
    public String getPermutation(int n, int k) {

        return null;
    }


    /**
     * 朋友圈
     * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
     * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
     * <p>
     * <p>
     * 深度优先搜索
     */
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }


    //广度优先搜索
    public int findCircleNum2(int[][] M) {

        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0)
                            queue.add(j);
                    }
                }
                count++;
            }
        }
        return count;
    }


    /**
     * 合并区间
     * 给出一个区间的集合，请合并所有重叠的区间。
     */
    public int[][] merge(int[][] intervals) {

        return null;

    }

    /**
     * 接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */
    public int trap(int[] height) {

        return 0;
    }


}
