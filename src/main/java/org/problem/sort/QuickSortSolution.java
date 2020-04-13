package org.problem.sort;

/**
 * 快速排序的最坏运行情况是 O(n²)，比如说顺序数列的快排。但它的平摊期望时间是 O(nlogn)，
 * 且 O(nlogn) 记号中隐含的常数因子很小，比复杂度稳定等于 O(nlogn) 的归并排序要小很多。
 * 所以，对绝大多数顺序性较弱的随机数列而言，快速排序总是优于归并排序。
 */
public class QuickSortSolution {

    public static void main(String[] args) {

        int[] arrays = new int[]{2, 31, 4, 9, 21, 31, 88, 7, 10, 6, 11};
        int[] result = quickSort(arrays, 0, arrays.length - 1);
        for (int value : result) {
            System.out.println(value);
        }

    }

    /**
     * 从数列中挑出一个元素，称为 "基准"（pivot）;
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
     */
    public static int[] quickSort(int[] sourceArray, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(sourceArray, left, right);
            quickSort(sourceArray, left, partitionIndex - 1);
            quickSort(sourceArray, partitionIndex + 1, right);
        }
        return sourceArray;
    }

    /**
     * 基准值
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
