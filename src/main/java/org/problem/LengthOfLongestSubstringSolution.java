package org.problem;


/**
 * 最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 时间复杂度o(n)
 * 思路：快慢指针法（前提是"字符串"）
 */
public class LengthOfLongestSubstringSolution {


    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("hdfasldh"));

    }


    /**
     *  其中都是字符串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        int[] hash = new int[500];
        int max = 0;
        int i = 0, j = 0;

        while (i < s.length() && j < s.length()) {
            if (hash[s.charAt(j)] == 0) {
                hash[s.charAt(j)] = 1;
                j++;
                max = Math.max((j - i), max);
            } else {
                hash[s.charAt(i)] = 0;
                i++;
            }
        }

        return max;
    }


}
