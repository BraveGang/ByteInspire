package org.example.sort;

/**
 * 归并排序
 * 时间复杂度：nlogn
 */
public class MergeSortSolution {


    public static void main(String[] args) {

        int array[] = new int[]{2, 31, 4, 9, 21, 31, 88, 7};

        mergeSort2(array);

        // int result[] = mergeSort(array, 0, array.length - 1);

        for (int value : array) {
            System.out.println(value);
        }

//        System.out.println("==========");
//        for (int value : result) {
//            System.out.println(value);
//        }

    }

    private static int[] mergeSort(int[] nums, int low, int high) {

        if (low == high) {
            return new int[]{nums[low]};
        }
        int mid = low + (high - low) / 2;
        int[] leftArr = mergeSort(nums, low, mid); //左有序数组
        int[] rightArr = mergeSort(nums, mid + 1, high); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组
        int m = 0, i = 0, j = 0;

        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }


        while (i < leftArr.length) {
            newNum[m++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            newNum[m++] = rightArr[j++];
        }

        return newNum;
    }

    //方法2
    private static void mergeSort2(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        sort(arr, L, mid);
        sort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while (p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }

}
