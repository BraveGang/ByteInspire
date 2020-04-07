package org.problem.linked;

import org.helper.ListNode;

/**
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class IntersectionNodeSolution {

    public static void main(String[] args) {

    }


    /**
     * 暴力法-双层遍历-查找相同的节点
     * 时间复杂度 : (mn)(mn)
     * 空间复杂度 : O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        return null;
    }


    /**
     * 哈希表法-遍历链表A， 并将每个结点的地址/引用存储在哈希表中，
     * 然后检查链表B是否存在节点在链表A只中
     */

    public ListNode getIntersectionNodeHash(ListNode headA, ListNode headB) {

        return null;
    }


    /**
     * 双指针法
     * 创建两个指针 pA 和 pB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历
     * 当pA到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B); 类似的，当 pB 到达链表的尾部时，将它重定位到链表 A 的头结点
     * 若在某一时刻 pA 和 pB 相遇，则 pA/pB 为相交结点
     */

    public ListNode getIntersectionNodeP(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;

    }

}
