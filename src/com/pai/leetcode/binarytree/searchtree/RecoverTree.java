package com.pai.leetcode.binarytree.searchtree;

import com.pai.leetcode.binarytree.entity.TreeNode;
import com.pai.leetcode.util.TreeNodeUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * 恢复二叉搜索树
 * 这个题，初看好像很难，可是我们牢记二叉搜索树中序遍历是有序的这一条件，即可得出，将二叉搜索树中序遍历，交换序列中顺序错误的两个值
 */
public class RecoverTree {
    public void recoverTree(TreeNode root) {
        // 获取中序遍历结果
        List<Integer> list = inorderTraversal(root);
        int left = -1;
        int right = -1;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i) >= list.get(j)) {
                    left = list.get(i);
                    right = list.get(j);
                    break;
                }
            }
        }
        swap(root, left, right);
    }

    private void swap(TreeNode root, int left, int right) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.val == left) {
                current.val = right;
            }
            if (current.val == right) {
                current.val = left;
            }
            current = current.right;
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
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

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtil.arrayToTree(new Integer[]{1, 3, null, null, 2});
        RecoverTree recoverTree = new RecoverTree();
        recoverTree.recoverTree(treeNode);
        List<Integer> list = TreeNodeUtil.inorderTraversal(treeNode);
        list.forEach(System.out::print);
    }


}
