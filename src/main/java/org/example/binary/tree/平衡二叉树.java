package org.example.binary.tree;

public class 平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }


    /**
     * 获取当前二叉树的深度
     * @param root
     * @return
     */
    public int getDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

    }
}
