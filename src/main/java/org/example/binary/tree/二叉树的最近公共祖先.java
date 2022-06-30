package org.example.binary.tree;

public class 二叉树的最近公共祖先 {


    /**
     * 二叉树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null){
            return null;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode == null && rightNode == null){
            return null;
        }

        if (leftNode == null){
            return rightNode;
        }

        if (rightNode == null){
            return leftNode;
        }
        return root;
    }


    /**
     * 二叉树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || p == root || q == root){
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor1(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor1(root.right, p, q);

        if (leftNode != null && rightNode != null){
            return root;
        } else if (leftNode != null && rightNode == null){
            return leftNode;
        } else {
            return rightNode;
        }
    }



    public static void main(String[] args) {

    }
}
