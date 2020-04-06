package org.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个int数组，将正数移动到数组左边，负数移动到数组右边
 * 要求时间复杂度为O(n)
 */
public class PositiveNegativeSwapSolution {

    public static void main(String[] args) {

        int[] nums = new int[]{8, 6, 4, -3, 5, -2, -1, 0, 1, -9, 1, -1};

        //numSwap(nums);
        numSwap2(nums);

        for (int num : nums) {
            System.out.println(num);
        }

    }

    /**
     * 维护一个下标 然后swap
     *
     * @param nums
     */
    public static void numSwap(int[] nums) {

        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && index == -1) {
                index = i;
            }
            if (nums[i] < 0 && index != -1) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                i = index;
                index = -1;
            }
        }
    }


    /**
     * 分治法：两个List分别存储 然后再合并
     *
     * @param nums
     */
    public static void numSwap2(int[] nums) {

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (Integer num : nums) {
            if (num < 0) {
                negative.add(num);
            } else {
                positive.add(num);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < negative.size()) {
                nums[i] = negative.get(i);
            } else {
                nums[i] = positive.get(i - negative.size());
            }
        }
    }

}




