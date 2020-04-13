package org.problem.sort;

/**
 * 归并排序
 * 时间复杂度：nlogn
 */
public class MergeSortSolution {

    public static void main(String[] args) {
        int array[] = new int[]{2, 31, 4, 9, 21, 31, 88, 7};
        int result[] = mergeSort(array, 0, array.length - 1);
        for (int value : result) {
            System.out.println(value);
        }

    }

    /**
     * 默认为升序排列 ASC
     * 请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
     * 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
     * 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
     * 重复步骤 3 直到某一指针达到序列尾；
     * 将另一序列剩下的所有元素直接复制到合并序列尾。
     *
     * @param sourceArray
     * @param left
     * @param right
     * @return
     */
    public static int[] mergeSort(int[] sourceArray, int left, int right) {

        if (left == right) {
            return new int[]{sourceArray[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftArr = mergeSort(sourceArray, left, mid); //左有序数组
        int[] rightArr = mergeSort(sourceArray, mid + 1, right); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组
        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
            //newNum[m++] = Math.min(leftArr[i++],rightArr[j++]);
        }
        while (i < leftArr.length) {
            newNum[m++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            newNum[m++] = rightArr[j++];
        }
        return newNum;
    }

    /**
     * 降序排列
     *
     * @param sourceArray
     * @param left
     * @param right
     * @return
     */
    public static int[] mergeSortDesc(int[] sourceArray, int left, int right) {

        if (left == right) {
            return new int[]{sourceArray[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftArr = mergeSortDesc(sourceArray, left, mid); //左有序数组
        int[] rightArr = mergeSortDesc(sourceArray, mid + 1, right); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组
        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] > rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length) {
            newNum[m++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            newNum[m++] = rightArr[j++];
        }
        return newNum;

    }


}
