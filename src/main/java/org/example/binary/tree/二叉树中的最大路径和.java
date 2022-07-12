package org.example.binary.tree;

public class 二叉树中的最大路径和 {

    /**
     * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        Integer val = Integer.MIN_VALUE;
        maxPathSum(root, val);
        return val;
    }


    public int maxPathSum (TreeNode root, int val){
        if (root == null){
            return 0;
        }

        int left = Math.max(0, maxPathSum(root.left, val));
        int right = Math.max(0, maxPathSum(root.right, val));

        val = Math.max(val, root.val + left + right);

        return root.val + Math.max(left, right);
    }


    public static void main(String[] args) {

    }
}
