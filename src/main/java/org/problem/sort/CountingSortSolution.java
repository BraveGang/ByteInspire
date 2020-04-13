package org.problem.sort;

import java.util.Arrays;

/**
 * 计数排序
 * （1）找出待排序的数组中最大和最小的元素
 * （2）统计数组中每个值为i的元素出现的次数，存入数组C的第i项
 * （3）对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）
 * （4）反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1
 */
public class CountingSortSolution {

    public static void main(String[] args) {
        int[] arrays = new int[]{2, 31, 4, 9, 21, 31, 88, 7, 10, 6, 11};
        int[] result = countingSort(arrays);
        for (int value : result) {
            System.out.println(value);
        }
    }

    public static int[] countingSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxValue = getMaxValue(arr);
        return sort(arr, maxValue);
    }

    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    private static int[] sort(int[] arr, int maxValue) {

        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];
        for (int value : arr) {
            bucket[value]++;
        }
        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

}
