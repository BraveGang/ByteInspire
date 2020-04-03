package org.problem.linked;

import org.example.node.ListNode;

/**
 * 反转一个单链表
 */
public class ReverseListSolution {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        //ListNode resultNode = reverseList(node1);
        ListNode resultNode = reverseList2(node1);
        MergeTwoListsSolution.printListFromHeadToTail(resultNode);

    }

    /**
     * 递归方式
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;

    }


    /**
     * 双指针法
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {

        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }

    /**
     * 双指针法 2
     *
     * @param head
     * @return
     */
    public static ListNode reverseList3(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (head.next != null) {
            ListNode t = head.next.next;
            head.next.next = cur;
            cur = head.next;
            head.next = t;
        }

        return cur;

    }


}
