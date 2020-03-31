package org.problem;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 */
public class MaxSubArraySolution {

    public static void main(String[] args) {

        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));

    }

    /**
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int max = nums[0];

        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            }
            if (sum <= 0) {
                sum = num;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

}
