package org.problem.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度：n2
 */
public class InsertSortSolution {

    public static void main(String[] args) {
        int[] arrays = new int[]{2, 31, 4, 9, 21, 31, 88, 7};
        int[] result = insertSort(arrays);
        for (int value : result) {
            System.out.println(value);
        }
    }

    /**
     * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
     * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
     * （如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
     */
    public static int[] insertSort(int[] sourceArray) {

        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i;
            while (j > 0 && key < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = key;
            }
        }
        return arr;
    }


}
