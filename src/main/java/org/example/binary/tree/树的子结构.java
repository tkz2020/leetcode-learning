package org.example.binary.tree;

public class 树的子结构 {

    /**
     * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }


    public boolean dfs(TreeNode A, TreeNode B){
        if (B == null){
            return true;
        }

        if (A == null || A.val != B.val){
            return false;
        }

        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }

    public static void main(String[] args) {


    }
}
