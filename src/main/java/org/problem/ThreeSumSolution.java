package org.problem;

import java.util.*;

/**
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 */
public class ThreeSumSolution {

    public static void main(String[] args) {

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = directlySolution(nums);
        List<List<Integer>> lists2 = squeezeSolution(nums);

}

    /**
     * 暴力解法：三层for循环遍历实现
     */
    public static List<List<Integer>> directlySolution(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }

        //这里直接调用的排序API
        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> value = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(value);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * 三数之和：夹逼法
     * 设置两个指针，头尾向中间逼近，并计算结果
     */
    public static List<List<Integer>> squeezeSolution(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }

        Set<List<Integer>> result = new LinkedHashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = -(nums[head] + nums[tail]);
                if (sum == nums[i]) {
                    List<Integer> value = Arrays.asList(nums[i], nums[head], nums[tail]);
                    result.add(value);
                }
                if (sum <= nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }
        }

        return new ArrayList<>(result);
    }


    /**
     * 三数之和：夹逼法快速版
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> squeezeFastSolution(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // 加速1：c为非负数，就不能满足a+b+c=0了
            if (nums[i] > 0) {
                return result;
            }

            // 加速2：跳过计算过的数据，同时防止结果重复
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = -(nums[head] + nums[tail]);
                if (sum == nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    // 加速3：跳过计算过的数据，同时防止结果重复
                    while (head < tail && nums[head] == nums[head + 1]) {
                        head++;
                    }
                    while (head < tail && nums[tail] == nums[tail - 1]) {
                        tail--;
                    }
                }

                if (sum <= nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }

        }

        return result;
    }


}
