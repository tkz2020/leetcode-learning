package org.example.binary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树后序遍历：左子树 ---> 右子树 ---> 根结点
 */
public class 二叉树的后续遍历 {

    /**
     * 二叉树的后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        postorderDfs(root, resultList);
        return resultList;
    }


    /**
     * 二叉树后续遍历(递归遍历)
     * @param root
     * @param resultList
     */
    private void postorderDfs(TreeNode root, List<Integer> resultList){
        if (root == null){
            return;
        }

        postorderDfs(root.left, resultList);
        postorderDfs(root.right, resultList);
        resultList.add(root.val);
    }


    public static void main(String[] args) {

    }
}
