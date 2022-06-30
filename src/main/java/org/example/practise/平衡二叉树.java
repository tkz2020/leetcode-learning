package org.example.practise;

public class 平衡二叉树 {

    /**
     * 110. 平衡二叉树
     * 判断一个树是否为平衡二叉树
     * 一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }


    public int getDepth(TreeNode rootNode){
        if (rootNode == null){
            return 0;
        }

        return Math.max(getDepth(rootNode.left), getDepth(rootNode.right)) + 1;
    }

    public static void main(String[] args) {

    }
}
