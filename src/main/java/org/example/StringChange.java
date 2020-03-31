package org.example;

/**
 * 挑战字符串
 */
public class StringChange {

    public static void main(String[] args) {

        String str = "how old are you!";
        System.out.println(reverseWords(str));

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
        //面试的时候不能这样写哈
        //leetcode 有对应的题解
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



}
