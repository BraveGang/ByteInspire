package org.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//括号匹配问题 这个问题小米和头条一面都问了
//下面的程序是我自己写的，可以去网上找找看其他的方法
//这个问题是多解法的-当前是使用左括号压栈的方式实现
//(())(()))))()
public class BracketsMatchingSolution {

    public static void main(String[] args) {

        String strss = "(())(()))))()";
        List<Integer> list = bracketsMatching(strss);
        System.out.println("匹配数量：" + list.size());

        for (Integer index : list) {
            System.out.println("右括号深度：" + index);
        }

    }

    /**
     * 压栈的方式实现
     * @param s
     * @return
     */
    public static List<Integer> bracketsMatching(String s) {

        if (s == null || s.length() == 0) {
            return null;
        }

        List<Integer> list = new ArrayList<>();

        int count = 0;
        int index = 0;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            index++;

            if ('(' == aChar) {
                stack.add(aChar);
            }

            if (')' == aChar && !stack.empty()) {
                stack.pop();
                count++;
                list.add(index);
            }

        }

        return list;
    }


}
