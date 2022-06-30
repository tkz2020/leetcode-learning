package org.example.binary.tree;

public class 对称二叉树 {

    /**
     * 101. 对称二叉树
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }


    /**
     * 递归遍历左子树和右子树
     * @param leftTreeNode
     * @param rightTreeNode
     * @return
     */
    public boolean isSymmetric(TreeNode leftTreeNode, TreeNode rightTreeNode){
        if (leftTreeNode == null && rightTreeNode == null){
            return true;
        }

        if (leftTreeNode == null || rightTreeNode == null){
            return false;
        }

        if (leftTreeNode.val != rightTreeNode.val){
            return false;
        }

        return isSymmetric(leftTreeNode.left, rightTreeNode.right) && isSymmetric(leftTreeNode.right, rightTreeNode.left);
    }

    public static void main(String[] args) {

    }
}
