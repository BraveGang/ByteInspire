package org.problem.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)
 */
public class LongestConsecutiveSolution {


    public static void main(String[] args) {
        // [100, 4, 200, 1, 3, 2]
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }


    /**
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {

        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for (int num : num_set) {
            //找出连续序列的起点
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

}
