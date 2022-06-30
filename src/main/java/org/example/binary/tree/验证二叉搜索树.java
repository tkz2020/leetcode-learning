package org.example.binary.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class 验证二叉搜索树 {

    /**
     * 98. 验证二叉搜索树
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     *
     * 有效 二叉搜索树定义如下：
     *
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/validate-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        Integer inOrder = null;
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()){
            while (root != null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            //二叉树中序遍历，前一个节点值大于后面的节点值
            if (inOrder != null && inOrder >= root.val){
                return false;
            }
            inOrder = root.val;
            root = root.right;
        }
        return true;
    }


    public boolean isValidBST1(TreeNode root){
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    public boolean isValidBST(TreeNode root, long lowValue, long highValue){
        if (root == null){
            return true;
        }

        if (root.val <= lowValue || root.val >= highValue){
            return false;
        }

        return isValidBST(root.left, lowValue, root.val) && isValidBST(root.right, root.val, highValue);
    }


    public static void main(String[] args) {

    }
}
