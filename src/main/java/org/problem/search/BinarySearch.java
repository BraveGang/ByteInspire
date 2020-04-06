package org.problem.search;

/**
 * 二分查找
 * 前提是有序数组
 */
public class BinarySearch {


    public static void main(String[] args) {

    }

    /**
     * 二分查找-递归法
     *
     * @param arr
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int recursionBinarySearch(int[] arr, int key, int low, int high) {

        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        int middle = (low + high) / 2; //初始中间位置
        if (arr[middle] > key) {
            //比关键字大则关键字在左区域
            return recursionBinarySearch(arr, key, low, middle - 1);
        } else if (arr[middle] < key) {
            //比关键字小则关键字在右区域
            return recursionBinarySearch(arr, key, middle + 1, high);
        } else {
            return middle;
        }

    }

    /**
     * 二分查找-循环遍历法
     * 推荐使用：Java源码二分查找就是用的while循环法
     *
     * @param arr
     * @param key
     * @return
     */
    public static int commonBinarySearch(int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;
        int middle = 0;            //定义middle
        if (key < arr[low] || key > arr[high]) {
            return -1;
        }

        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] > key) {
                //比关键字大则关键字在左区域
                high = middle - 1;
            } else if (arr[middle] < key) {
                //比关键字小则关键字在右区域
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return -1; //最后仍然没有找到，则返回-1
    }
}
