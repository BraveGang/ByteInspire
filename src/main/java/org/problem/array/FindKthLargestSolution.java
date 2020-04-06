package org.problem.array;

import org.problem.sort.MergeSortSolution;

/**
 * 数组中的第K 个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 先对数组进行降序排列  然后取下标k-1
 *
 *  考察点：排序
 */
public class FindKthLargestSolution {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 5, 8, 7, 3, 6};
        System.out.println(findKthLargest(nums, 1));

    }

    public static int findKthLargest(int[] nums, int k) {

        // 先对数组进行降序排列
        int[] newNum = MergeSortSolution.mergeSortDesc(nums, 0, nums.length - 1);
        //这是直接调用的API排序方法，实际面试考察中，不能这么写，自选一种排序算法实现，我习惯用归并排序
        //Arrays.sort(nums);
        // 返回第K个最大值（下标k-1）
        return newNum[k - 1];

    }


}
