package org.problem.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSortSolution {

    public static void main(String[] args) {

        int[] arrays = new int[]{2, 31, 4, 9, 21, 31, 88, 7, 10, 6, 11};
        int[] result = radixSort(arrays);
        for (int value : result) {
            System.out.println(value);
        }

    }

    /**
     * 基数排序：根据键值的每位数字来分配桶；
     * 计数排序：每个桶只存储单一键值；
     * 桶排序：每个桶存储一定范围的数值；
     * @param sourceArray
     * @return
     */
    public static int[] radixSort(int[] sourceArray) {

        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxDigit = getMaxDigit(arr);
        return radixSort(arr, maxDigit);

    }

    /**
     * 获取最高位数
     */
    private static int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
    }

    /**
     * @param arr
     * @return
     */
    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }


    /**
     * @param num
     * @return
     */
    protected static int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    /**
     * @param arr
     * @param maxDigit
     * @return
     */
    private static int[] radixSort(int[] arr, int maxDigit) {

        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
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
    private static int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
