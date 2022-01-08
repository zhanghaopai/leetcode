package com.pai.leetcode.util;


import com.pai.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode将一维数组转换为TreeNode工具类
 */
public class TreeNodeUtil {
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
}
