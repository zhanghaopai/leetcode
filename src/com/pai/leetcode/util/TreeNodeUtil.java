package com.pai.leetcode.util;


import com.pai.leetcode.binarytree.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * leetcode将一维数组转换为TreeNode工具类
 */
public class TreeNodeUtil {
    /**
     * leetcode 层序遍历转换为根节点
     * @param array 层序遍历数组
     * @return 根节点
     */
    public static TreeNode arrayToTree(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        // 初始化根节点
        TreeNode root = new TreeNode(array[0]);
        // 初始化队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            // 从序号1的元素开始遍历，查看队顶元素，则下两个元素就是队顶元素的左右子树，如果左右子树不为空则加入队列，直到数组末尾
            TreeNode node = queue.peek();
            if (isLeft) {
                // 左子树
                if (array[i]!=null) {
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            }else{
                if (array[i]!=null) {
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                // 右子树查看完毕，该节点遍历完毕，删除
                queue.poll();
                // 右子树
                isLeft = true;
            }
        }
        return root;
    }

    /**
     * 中序遍历，得到的list可使用list.foreach(System.out::print)打印输出
     * @param root 根节点
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);
            current = current.right;
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }
        return list;
    }
}
