package org.example.binary.tree;

public class 相同的二叉树 {

    /**
     * NC315 相同的二叉树
     * https://www.nowcoder.com/practice/5a3b2cf4211249c89d6ced7987aeb775?tpId=196&tqId=40271&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D2%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=2&judgeStatus=undefined&tags=&title=
     * @param root1
     * @param root2
     * @return
     */
    public boolean isSameTree (TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return true;
        }

        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)){
            return false;
        }

        if (root1.val != root2.val){
            return false;
        }

        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}
