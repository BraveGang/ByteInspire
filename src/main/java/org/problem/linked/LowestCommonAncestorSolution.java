package org.problem.linked;


import org.helper.TreeNode;

/**
 * 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class LowestCommonAncestorSolution {

    public static void main(String[] args) {

    }


    /**
     * 解法-递归
     * 时间复杂度 logn - n
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q)
            return root;

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode == null)
            return rightNode;
        if (rightNode == null)
            return leftNode;

        return root;

    }


}
