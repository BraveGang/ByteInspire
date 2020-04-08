package org.problem.sort;

/**
 * 插入排序
 * 时间复杂度：n2
 */
public class InsertSortSolution {

    public static void main(String[] args) {
        int array[] = new int[]{2, 31, 4, 9, 21, 31, 88, 7};
        insertSort(array);
        for (int value : array) {
            System.out.println(value);
        }
    }

    private static int[] insertSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return arr;
        }
        //优化写法，别上来就动不动来个两层for循环，low不low
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j > 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }


}
