package org.example;

/**
 * 挑战字符串
 */
public class StringChange {

    public static void main(String[] args) {

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
     * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
     */
    public String simplifyPath(String path) {

        return null;
    }



}
