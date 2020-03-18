package org.example.sort;

/**
 * 插入排序
 * 时间复杂度：n2
 */
public class InsertSortSolution {

    public static void main(String[] args) {
        int array[] = new int[]{2, 31, 4, 9, 21, 31, 88, 7};
        insertSort2(array);
        for (int value : array) {
            System.out.println(value);
        }
    }

    private static int[] insertSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    private static int[] insertSort2(int[] arr) {

        if (arr == null || arr.length < 2) {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int index = i;
            for (int j = i; j > 0; j--) {
                if (temp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    index = j - 1;
                } else {
                    break;
                }
                arr[index] = temp;
            }
        }
        return arr;
    }

}
