package org.problem.linked;

import org.helper.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 *
 * 补充：这个问题2018年面试瓜子二手车的时候 考过我 当时没答上来 现在想想 也挺简单的啊 主要是思路
 */
public class DetectCycleSolution {


    public static void main(String[] args) {

    }

    /**
     * 解法：哈希表
     *
     * @param head
     * @return
     */
    public ListNode detectCycleHash(ListNode head) {

        Set<ListNode> visited = new HashSet<>();

        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }

        return null;

    }

    /**
     * Floyd 算法: 快慢指针（链表内若存在环，快指针一定可以追上慢指针）
     * 每次移动慢指针一步、快指针两步，直到快指针无法继续往前移动
     * 快慢指针指向了同一个节点，就将它返回它
     */
    public ListNode detectCycleFloyd(ListNode head) {

        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == slowPointer) {
                return slowPointer;
            }
        }
        return null;
    }


}
