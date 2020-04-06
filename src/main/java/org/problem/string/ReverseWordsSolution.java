package org.problem.string;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 */
public class ReverseWordsSolution {

    public static void main(String[] args) {

        String str = "how old are you!";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String s) {

        String[] arrayStr = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = arrayStr.length - 1; i >= 0; i--) {
            stringBuffer.append(arrayStr[i]);
            if (i - 1 >= 0) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }


}
