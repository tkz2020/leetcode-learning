package org.example.binary.tree;

public class 合并二叉树 {

    /**
     * BM32 合并二叉树
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        if (t1 == null && t2 == null){
            return null;
        }

        if (t1 == null || t2 == null){
            return t1 == null ? t2 : t1;
        }

        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }

    public static void main(String[] args) {

    }
}
