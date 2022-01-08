package com.pai.leetcode.binarytree.traverse;

import com.pai.leetcode.binarytree.entity.TreeNode;
import com.pai.leetcode.util.TreeNodeUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 中序遍历
 */
public class InorderTraversal {
    // 中序遍历递归法
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        inorderTraversalRecursion(root, result);
        return result;
    }

    private void inorderTraversalRecursion(TreeNode root, List<Integer> list) {
        if (root==null) {
            // 递归结束
            return;
        }
        inorderTraversalRecursion(root.left, list);
        list.add(root.val);
        inorderTraversalRecursion(root.right, list);
    }

    // 中序遍历循环迭代法
    public List<Integer> inorderTraversalIteration(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 先将所有的左子树压栈
        while (root!=null) {
            stack.push(root);
            root = root.left;
        }
        // 当栈不空时
        while (!stack.isEmpty()) {
            // 弹出最左侧的节点
            TreeNode current = stack.pop();
            result.add(current.val);
            // 准备去处理当前节点的右节点，一样的需要把所有的左节点入栈，走到最左侧
            current = current.right;
            while (current!=null) {
                stack.push(current);
                current = current.left;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 递归法测试
        InorderTraversal inorderTraversal = new InorderTraversal();
        TreeNode treeNode = TreeNodeUtil.arrayToTree(new Integer[]{1, null, 2, 3});
        System.out.println("=======================================================");
        List<Integer> result1 = inorderTraversal.inorderTraversalRecursion(treeNode);
        result1.forEach(System.out::println);

        // 迭代法测试
        System.out.println("=======================================================");
        List<Integer> result2 = inorderTraversal.inorderTraversalIteration(treeNode);
        result2.forEach(System.out::println);
    }
}
