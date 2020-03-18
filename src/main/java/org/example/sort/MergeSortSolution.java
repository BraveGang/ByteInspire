package org.example.sort;

/**
 * 归并排序
 * 时间复杂度：nlogn
 */
public class MergeSortSolution {


    public static void main(String[] args) {

        int array[] = new int[]{2, 31, 4, 9, 21, 31, 88, 7};
        int result[] = mergeSort(array, 0, array.length - 1);

        for (int value : array) {
            System.out.println(value);
        }

        System.out.println("==========");

        for (int value : result) {
            System.out.println(value);
        }
    }

    private static int[] mergeSort(int[] nums, int low, int high) {

        if (low == high) {
            return new int[]{nums[low]};
        }
        int mid = low + (high - low) / 2;
        int[] leftArr = mergeSort(nums, low, mid); //左有序数组
        int[] rightArr = mergeSort(nums, mid + 1, high); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组
        int m = 0, i = 0, j = 0;

        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }


        while (i < leftArr.length) {
            newNum[m++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            newNum[m++] = rightArr[j++];
        }

        return newNum;
    }
}
