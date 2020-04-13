package org.problem.sort;

import java.util.Arrays;

/**
 * 桶排序
 * 在额外空间充足的情况下，尽量增大桶的数量
 * 使用的映射函数能够将输入的 N 个数据均匀的分配到 K 个桶中
 */
public class BucketSortSolution {

    public static void main(String[] args) {

        int[] arrays = new int[]{2, 31, 4, 9, 21, 31, 88, 7, 10, 6, 11};
        int[] result = bucketSort(arrays);
        for (int value : result) {
            System.out.println(value);
        }

    }

    /**
     * @param sourceArray
     * @return
     */
    public static int[] bucketSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return sort(arr, 5);

    }

    private static int[] sort(int[] arr, int bucketSize) {

        if (arr.length == 0) {
            return arr;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        // 利用映射函数将数据分配到各个桶中
        for (int item : arr) {
            int index = (int) Math.floor((item - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], item);
        }
        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }

            // 对每个桶进行排序，这里使用了插入排序
            bucket = InsertSortSolution.insertSort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
        return arr;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     * @return
     */
    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

}
