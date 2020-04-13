package org.problem.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 希尔排序，也称递减增量排序算法，是插入排序的一种更高效的改进版本。
 * 但希尔排序是非稳定排序算法。
 */
public class HeapSortSolution {

    public static void main(String[] args) {

        int[] arrays = new int[]{2, 31, 4, 9, 21, 31, 88, 7, 10, 6, 11};
        int[] result = heapSort(arrays);
        for (int value : result) {
            System.out.println(value);
        }

    }

    /**
     *
     * 创建一个堆 H[0……n-1]；
     * 把堆首（最大值）和堆尾互换；
     * 把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
     * 重复步骤 2，直到堆的尺寸为 1
     *
     * @param sourceArray
     * @return
     */
    public static int[] heapSort(int[] sourceArray) {

        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = arr.length;
        buildMaxHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;

    }

    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
