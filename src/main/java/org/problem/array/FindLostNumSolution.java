package org.problem.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在无序数组中寻找两个出现奇数次的数：
 * 一个无序数组里有若干个整数，只有2个整数出现了奇数次，如何找到这2个出现奇数次的整数
 * <p>
 * 美团二面算法--这个是我自己的解法、老铁们有啥更好的方法更新分享哈
 */
public class FindLostNumSolution {


    public static void main(String[] args) {

        int[] array = {4, 1, 2, 2, 1, 3, 5, 5, 4, 5};
        int[] result = findLostNum(array);
        System.out.println(result[0] + " " + result[1]);

    }


    /**
     * 
     * @param array
     * @return
     * 借助Map的特性
     *
     */
    public static int[] findLostNum(int[] array) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int num : array) {
            map.put(num, 0);
        }

        for (int num : array) {
            if (map.containsKey(num)) {
                int value = map.get(num) + 1;
                map.put(num, value);
            }
        }

        //遍历Map
        for (Integer key : map.keySet()) {
            int count = map.get(key);
            //判断出现奇数次数据
            if (count != 0 && (count & 1) != 0) {
                list.add(key);
            }
        }

        int[] nums = new int[2];
        nums[0] = list.get(0);
        nums[1] = list.get(1);

        return nums;
    }


}
