package org.problem.string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀
 * 如果不存在公共前缀，返回空字符串 ""
 */
public class LongestCommonPrefixSolution {

    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"fla", "flo", "flow", "flw"}));

    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (String s : strs) {
            while (s.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    return "";
                }
            }
        }
        return prefix;
    }


}
