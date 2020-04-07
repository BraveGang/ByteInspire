package org.problem.linked;

import org.helper.ListNode;

/**
 * 两个数字相加
 * 给定一个链表`L1`、`L2`,每个元素是为10以内的正整数，链表表示一个数字，表头为高位。 求两个链表之和，以链表形式返回
 * 如：L1{ 5 -> 6 -> 2 -> 3 -> 7}， L2 { 9 -> 5}
 * 和为： 56237+95 = 56332，需要自己创建链表结构
 *
 * 头面面试题：我跟你说，头条特别喜欢考察链表相关的
 */
public class AddTwoNumbers2Solution {

    public static void main(String[] args) {

    }


    /**
     * 先倒序、再求和
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //反转链表
        ListNode ln1 = ReverseListSolution.reverseList(l1);
        ListNode ln2 = ReverseListSolution.reverseList(l2);
        //求和
        return AddTwoNumbersSolution.addTwoNumbers(ln1, ln2);

    }


}
