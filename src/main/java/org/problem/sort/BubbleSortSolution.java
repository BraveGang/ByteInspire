package org.problem.sort;

import java.util.Arrays;

/**
 *
 */
public class BubbleSortSolution {

    public static void main(String[] args) {
        int[] arrays = new int[]{2, 31, 4, 9, 21, 31, 88, 7};
        int[] result = bubbleSort(arrays);
        for (int value : result) {
            System.out.println(value);
        }
    }

    /**
     *
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
     *
     * @param sourceArray
     * @return
     */
    public static int[] bubbleSort(int[] sourceArray) {

        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = sourceArray.length;
        for (int i = 1; i < len; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，
            // 也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            for (int j = 0; j < len - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }

            }

            if (flag) {
                break;
            }
        }

        return arr;
    }

}
