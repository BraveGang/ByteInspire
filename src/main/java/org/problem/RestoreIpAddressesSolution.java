package org.problem;


import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddressesSolution {

    public static void main(String[] args) {

        String ipStr = "1981216176";
        List<String> stringList = restoreIpAddresses(ipStr);
        for (String s : stringList) {
            System.out.println(s);
        }

    }


    /**
     * 给定一个字符串、复原肯能的IP地址
     * 暴力解法：三层循环遍历输出
     *
     * @param s
     * @return
     */
    public static List<String> restoreIpAddresses(String s) {

        int len = s.length();
        if (len == 0 || len > 12) {
            return null;
        }

        List<String> result = new ArrayList<>();

        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    if (len - k >= 4) {
                        continue; //判断字符串 是否有剩余
                    }

                    int a = Integer.parseInt(s.substring(0, i));
                    int b = Integer.parseInt(s.substring(i, j));
                    int c = Integer.parseInt(s.substring(j, k));
                    int d = Integer.parseInt(s.substring(k));

                    if (a > 255 || b > 255 || c > 255 || d > 255) {
                        continue;
                    }

                    String ip = a + "." + b + "." + c + "." + d;

                    if (ip.length() < len + 3)
                        continue;

                    result.add(ip);

                }
            }
        }
        return result;
    }


    /**
     * 递归方式实现
     *
     * @param s
     * @return
     */
    public static List<String> restoreIpAddresses2(String s) {

        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        check(list, chars, "", 0, 0);
        return list;

    }

    private static void check(List<String> list, char[] chars, String str, int index, int count) {
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
