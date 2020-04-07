package org.problem.linked;

import org.helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 */
public class ZigzagLevelOrderSolution {


    public static void main(String[] args) {

    }

    /**
     * BFS（广度优先遍历）
     * 方法1：使用两层嵌套循环。外层循环迭代树的层级，内层循环迭代每层上的节点。
     * 方法2:也可以使用一层循环实现 BFS。将要访问的节点添加到队列中，
     * 使用 分隔符（例如：空节点）把不同层的节点分隔开。分隔符表示一层结束和新一层开始。
     * <p>
     * 时间复杂度：N
     * 空间复杂度：N
     * <p>
     * 推荐方案
     */
    public List<List<Integer>> zigzagLevelOrderBFS(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> results = new ArrayList<>();
        LinkedList<TreeNode> node_queue = new LinkedList<>();
        node_queue.addLast(root);
        node_queue.addLast(null);

        LinkedList<Integer> level_list = new LinkedList<>();
        boolean is_order_left = true;

        while (node_queue.size() > 0) {
            TreeNode curr_node = node_queue.pollFirst();
            if (curr_node != null) {
                if (is_order_left)
                    level_list.addLast(curr_node.val);
                else
                    level_list.addFirst(curr_node.val);

                if (curr_node.left != null)
                    node_queue.addLast(curr_node.left);

                if (curr_node.right != null)
                    node_queue.addLast(curr_node.right);

            } else {
                results.add(level_list);
                level_list = new LinkedList<>();
                if (node_queue.size() > 0)
                    node_queue.addLast(null);
                is_order_left = !is_order_left;
            }
        }
        return results;

    }

    /**
     *
     * DFS （深度优先遍历）
     * @return
     *
     */
    public List<List<Integer>> zigzagLevelOrderDFS(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> results = new ArrayList<>();
        DFS(root, 0, results);
        return results;
    }

    private void DFS(TreeNode node, int level, List<List<Integer>> results) {

        if (level >= results.size()) {
            LinkedList<Integer> newLevel = new LinkedList<Integer>();
            newLevel.add(node.val);
            results.add(newLevel);
        } else {
            if (level % 2 == 0)
                results.get(level).add(node.val);
            else
                results.get(level).add(0, node.val);
        }

        if (node.left != null) DFS(node.left, level + 1, results);
        if (node.right != null) DFS(node.right, level + 1, results);
    }


}
