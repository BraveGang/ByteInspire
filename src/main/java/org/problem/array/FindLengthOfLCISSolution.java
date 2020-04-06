package org.problem.array;

/**
 * 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 *
 */
public class FindLengthOfLCISSolution {


    public static void main(String[] args) {

        int[] nums = new int[]{7, 8, 9, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4};
        System.out.println(findLengthOfLCIS(nums));
        System.out.println(findLengthOfLCIS2(nums));

    }


    /**
     * 滑动窗口方法
     *
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS(int[] nums) {

        if (nums == null || nums.length < 2) {
            return -1;
        }

        int ans = 0;
        int anchor = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i])
                anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }

        return ans;
    }

    /**
     *
     * 快慢指针法
     *
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS2(int[] nums) {

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


}
