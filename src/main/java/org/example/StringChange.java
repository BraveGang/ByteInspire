package org.example;

import java.util.ArrayList;
import java.util.List;


/**
 * 挑战字符串
 */
public class StringChange {


    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("hdfasldflkasjdfljalsdf"));

        System.out.println("==========");

        String strs[] = new String[]{"fla", "flo", "flow", "flw"};
        System.out.println(longestCommonPrefix(strs));

        System.out.println("==========");

        String str = "how old are you!";
        System.out.println(reverseWords(str));

        System.out.println("==========");

        String ipStr = "25525511135";
        List<String> stringList = restoreIpAddresses(ipStr);
        for (String s : stringList) {
            System.out.println(s);
        }

    }


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
     * 时间复杂度o(n)
     * 思路：快慢指针法（前提是"字符串"）
     */
    public static int lengthOfLongestSubstring(String s) {
        //2 3 4 5 6 4 3 2 1
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


    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String str = strs[0];
        for (String s : strs) {
            while (s.indexOf(str) != 0) {
                str = str.substring(0, str.length() - 1);
                if (str.length() == 0) {
                    return "";
                }
            }
        }
        return str;

    }

    /**
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {

        if (s2.contains(s1)) {
            return true;
        } else {
            return false;
        }

    }


    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     */
    public static String multiply(String num1, String num2) {

        int num11 = Integer.parseInt(num1);
        int num22 = Integer.parseInt(num2);
        int num33 = num11 * num22;
        String str = String.valueOf(num33);
        return str;

    }

    /**
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     */
    public static String reverseWords(String s) {

        String arrayStr[] = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = arrayStr.length - 1; i >= 0; i--) {
            stringBuffer.append(arrayStr[i]);
            if (i - 1 >= 0) {
                stringBuffer.append(" ");
            }
        }
        String str = stringBuffer.toString();
        return str;
    }

    /**
     * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
     */
    public String simplifyPath(String path) {

        return null;
    }


    /**
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     */
    public static List<String> restoreIpAddresses(String s) {

        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        check(list, chars, "", 0, 0);
        return list;

    }

    public static void check(List<String> list, char[] chars, String str, int index, int count) {
        if (count == 4) {
            str = str.substring(0, str.length() - 1); //将最后一个.符号去掉
            if (index == chars.length) {
                String[] s = str.split("[.]");
                for (String num : s) {
                    if (Integer.valueOf(num) > 255) {
                        return;
                    }
                }
                list.add(str);
            }
            return;
        }

        String t = str;

        for (int i = 0; i < 3; i++) {
            if (index + i >= chars.length) {
                return;
            }

            t = t + chars[index + i];
            //递归调用
            check(list, chars, t + ".", index + i + 1, count + 1);
            if (i == 0 && chars[index + i] == '0') {//如果开头为0，不能往下执行
                return;
            }

        }
    }

}
