package com.pai.leetcode.binarytree.other;

import com.pai.leetcode.binarytree.entity.TreeNode;
import com.pai.leetcode.util.TreeNodeUtil;

/**
 * 相同的树，递归的思想，如果当前节点都不为null且值相同，或者都为null则当前节点相同，左子树同理，右子树同理
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q == null) {
            return true;
        }
        if (p!=null && q!=null &&p.val==q.val) {
            return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        SameTree sameTree = new SameTree();
        boolean sameTree1 = sameTree.isSameTree(TreeNodeUtil.arrayToTree(new Integer[]{1, 2, 3}),
                TreeNodeUtil.arrayToTree(new Integer[]{1, 2, 3}));
        boolean sameTree2 = sameTree.isSameTree(TreeNodeUtil.arrayToTree(new Integer[]{1, 2}),
                TreeNodeUtil.arrayToTree(new Integer[]{1, null, 2}));
        System.out.println(sameTree1);
        System.out.println(sameTree2);
    }
}
