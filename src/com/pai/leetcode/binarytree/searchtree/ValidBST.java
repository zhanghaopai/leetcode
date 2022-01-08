package com.pai.leetcode.binarytree.searchtree;

import com.pai.leetcode.binarytree.entity.TreeNode;
import com.pai.leetcode.util.TreeNodeUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 是否是有效的二叉搜索树
 *
 * @author zhanghaopai
 */
public class ValidBST {

    /**
     * 根据二叉搜索树中序遍历有序这一条件判断，如果一个二叉树中序遍历没有顺序那么，就说明该二叉树不是有效的搜索树
     * @param root 根节点
     * @return 是否是有效的二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        // 首先获得中序遍历结果
        List<Integer> list = new LinkedList<>();
        //    辅助栈
        Stack<TreeNode> stack = new Stack<>();
        //    首先获得最左侧节点
        while (root!=null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            // 获取最左侧节点
            TreeNode current = stack.pop();
            // 获取最左侧节点的值，其不可能再有左子树了，中序遍历，放入值
            list.add(current.val);
            // 指向最右侧节点
            current = current.right;
            // 找当前节点的最左侧节点
            while (current!=null) {
                stack.push(current);
                current = current.left;
            }
        }
        boolean flag = true;
        for (int i = 1; i<list.size();i++){
            if (list.get(i)<=list.get(i-1)) {
                // 当前节点比前一个节点要小，说明出错，记住二叉搜索树是左侧严格小于当前节点，右侧严格大于当前节点
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        ValidBST validBST = new ValidBST();
        boolean isValid = validBST.isValidBST(TreeNodeUtil.arrayToTree(new Integer[]{2, 2, 2}));
        System.out.println(isValid);
    }
}
