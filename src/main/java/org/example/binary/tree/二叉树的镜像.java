package org.example.binary.tree;

import java.util.Stack;

public class 二叉树的镜像 {

    /**
     * 剑指 Offer 27. 二叉树的镜像
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * 例如输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * 示例 1：
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }

        //递归到当前树的叶子节点的左节点
        TreeNode left = mirrorTree(root.left);
        //递归到当前树的叶子节点的右节点
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    /**
     * 二叉树的镜像，非递归
     * @param root
     * @return
     */
    public TreeNode mirrorTree1(TreeNode root){
        if (root == null){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.left != null){
                stack.push(node.left);
            }

            if (node.right != null){
                stack.push(node.right);
            }

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
