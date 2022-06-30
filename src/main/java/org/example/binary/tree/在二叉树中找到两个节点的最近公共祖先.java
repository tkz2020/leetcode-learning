package org.example.binary.tree;

public class 在二叉树中找到两个节点的最近公共祖先 {


    /**
     * BM38 在二叉树中找到两个节点的最近公共祖先
     * @param root
     * @param o1
     * @param o2
     * @return
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        TreeNode node = dfs(root, o1, o2);
        return node != null ? node.val : -1;
    }


    public TreeNode dfs(TreeNode root, int o1, int o2){
        if (root == null){
            return null;
        }

        if (root.val == o1 || root.val == o2){
            return root;
        }

        TreeNode leftNode = dfs(root.left, o1, o2);
        TreeNode rightNode = dfs(root.right, o1, o2);

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


    public static void main(String[] args) {

    }
}
