package org.problem.array;

import org.problem.sort.MergeSortSolution;

/**
 * 获取一个无需数组的中位数
 * 快手面试编程题
 * 方案如下：
 * 1、排序取下标中位数
 * 2、快排序思想
 * 3、建堆的思想
 */
public class MidNumSolution {

    public static void main(String[] args) {

        int[] nums = new int[]{100, 4, 200, 1, 3, 2, 7, 99};
        System.out.println(findMidNum(nums));

    }


    /**
     *
     * 先排序 再取中位数量
     * 排序种类有很多，选一个就好，下面的是归并排序实现
     * 注意：考虑数字长度奇偶数问题、偶数情况下的求均值策略
     * @param nums
     * @return
     */
    public static int findMidNum(int[] nums) {

        int[] sortNums = MergeSortSolution.mergeSort(nums, 0, nums.length - 1);

        int mid = (nums.length - 1) / 2;

        return sortNums[mid];

    }


    /**
     *
     * 快排序思想
     * @param arrays
     * @return
     */
    public static int findMidNum2(int[] arrays) {

        //TODO 自行实现吧 我当时用的是第一种方法

        return 0;

    }


}
