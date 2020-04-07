package org.problem.linked;

import org.helper.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 链表特性的基础考察
 */
public class PrintLinkedListFromTailToHead {

    public static void main(String[] args) {
        
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = null;
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode();

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        //使用栈实现逆序打印链表
        //printListFromTailToHeadByStack(node1);
        //使用递归实现逆序打印链表
        printListFromTailToHead(node1);
        //使用递归反转实现逆序打印
        //printListFromTailToHeadByReverseList(node1);
        //使用ArrayList逆序打印链表
        //printListFromTailToHeadByArrayList(node1);

    }


    /**
     * 方案一：通过使用栈结构，遍历链表，把先遍历的节点的值推入栈中，
     * 遍历结束后通过弹出栈内元素实现逆序打
     *
     * @param node
     */
    public static void printListFromTailToHeadByStack(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ",");
        }
    }

    /**
     * 方案二：递归法逆序打印链表
     *
     * @param node
     */
    public static void printListFromTailToHead(ListNode node) {

        if (node != null) {
            if (node.next != null) {
                printListFromTailToHead(node.next);
            }
            System.out.print(node.val + ",");
        } else {
            System.out.println("输入的链表为空");
        }

    }

    /**
     * 方案三：使用ArrayList逆序打印链表
     *
     * @param node
     */
    public static void printListFromTailToHeadByArrayList(ListNode node) {

        if (node == null) {
            System.out.print("输入链表为null");
        }

        List<Integer> arrayList = new ArrayList<>();

        while (node != null) {
            arrayList.add(node.val);
            node = node.next;
        }

        for (int i = arrayList.size() - 1; i >= 0; i--) {
            System.out.print(arrayList.get(i) + ",");
        }

    }


    /**
     * 方案四：递归反转链表，后遍历打印
     *
     * @param node
     */
    public static void printListFromTailToHeadByReverseList(ListNode node) {
        ListNode reversedNode = reverse(node);
        while (reversedNode != null) {
            System.out.print(reversedNode.val + ",");
            reversedNode = reversedNode.next;
        }
    }

    private static ListNode reverse(ListNode head) {
        if (head.next == null)
            return head;
        ListNode reversedListNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversedListNode;
    }


}
