package org.problem.linked;

import org.example.node.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并k个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 注意：高频问题，注意复杂度，正常情况 异常情况
 */
public class MergeKListsSolution {


    public static void main(String[] args) {


    }

    /**
     * 优先级队列
     * 时间复杂度：O(n∗log(k))，n 是所有链表中元素的总和，k 是链表个数。
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }

        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }

        return dummy.next;

    }


    /**
     * 分而治之
     * 链表两两合并
     * <p>
     * 时间复杂度：O(Nlogk) ，其中 k 是链表的数目。
     * 空间复杂度：O(1)
     */
    public static ListNode mergeKLists2(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private static ListNode merge(ListNode[] lists, int left, int right) {

        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return MergeTwoListsSolution.mergeTwoLists(l1, l2);

    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}