package org.problem.linked;


import org.helper.ListNode;


/**
 * 排序链表
 * 在 O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */
public class SortListSolution {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        ListNode listNode = sortList(node1);
        MergeTwoListsSolution.printListFromHeadToTail(listNode);


    }


    /**
     * 归并排序
     * 时间复杂度：logn
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        //快指针到队尾位置 慢指针到队列中位置
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        ListNode h = new ListNode(0);
        ListNode res = h;

        while (left != null && right != null) {

            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }

            h = h.next;
        }

        h.next = left != null ? left : right;
        return res.next;

    }


}
