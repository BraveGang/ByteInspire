package org.example;

import java.util.ArrayList;
import java.util.List;


/**
 * 挑战字符串
 */
public class StringChange {


    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("hdfasldflkasjdfljalsdf"));

        String strs[] = new String[]{"fla", "flo", "flow","flw"};
        System.out.println(longestCommonPrefix(strs));

        String str = "how old are you!";
        System.out.println(reverseWords(str));



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
    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }
        generateIpAddresses("", s, res);
        return res;

    }


    private void generateIpAddresses(String ipAddress, String s, List<String> res) {

        int n = 0;
        for (int i = 0; i < ipAddress.length(); i++) {
            if (ipAddress.charAt(i) == '.') {
                n++;
            }
        }

        if (n == 3) {

            if (ipAddress.length() - 3 < s.length()) {
                String lastString = s.substring(ipAddress.length() - 3);
                if (lastString.length() >= 4) {
                    return;
                }

                if (lastString.length() != 1 && lastString.charAt(0) == '0') {
                    return;
                }

                if (Integer.valueOf(lastString) >= 0 && Integer.valueOf(lastString) <= 255) {
                    res.add(ipAddress + lastString);
                }

            }
            return;
        }

        String[] nextString = new String[3];
        for (int i = 0; i < 3; i++) {
            if (ipAddress.length() - n + i + 1 <= s.length()) {
                nextString[i] = s.substring(ipAddress.length() - n, ipAddress.length() - n + i + 1);
                if (nextString[i].length() != 1 && nextString[i].charAt(0) == '0') {
                    continue;
                }
                if (Integer.valueOf(nextString[i]) >= 0 && Integer.valueOf(nextString[i]) <= 255) {
                    generateIpAddresses(ipAddress + nextString[i] + ".", s, res);
                }
            }
        }
    }

}

