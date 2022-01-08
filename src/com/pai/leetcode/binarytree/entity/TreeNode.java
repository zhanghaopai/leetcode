package com.pai.leetcode.binarytree.entity;

/**
 * 二叉树实体
 */
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
