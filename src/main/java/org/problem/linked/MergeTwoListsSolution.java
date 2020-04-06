package org.problem.linked;


import org.example.node.ListNode;


/**
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoListsSolution {


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        //ListNode sortNode = mergeTwoLists(node1, node4);
        ListNode sortNode2 = mergeTwoLists2(node1, node4);
        //printListFromHeadToTail(sortNode);
        printListFromHeadToTail(sortNode2);

    }

    /**
     * @param l1
     * @param l2
     * @return 递归实现方法
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    /**
     * 迭代法
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        //设置 ahead
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        //循环输出
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }


    public static void printListFromHeadToTail(ListNode node) {

        if (node != null) {
            System.out.print(node.val + " ");
            printListFromHeadToTail(node.next);
        }

    }

}
