package org.example.binary.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的中序遍历：左子树--->根节点--->右子树
 */
public class 二叉树的中序遍历 {

    /**
     * 二叉树中序遍历(递归)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        inorderDfs(root, resultList);
        return new ArrayList<>();
    }


    /**
     * 二叉树的中序遍历(递归)
     * @param root
     * @param resultList
     */
    private void inorderDfs(TreeNode root, List<Integer> resultList){
        if (root == null){
            return;
        }

        inorderDfs(root.left, resultList);
        resultList.add(root.val);
        inorderDfs(root.right, resultList);
    }


    /**
     * 二叉树中序遍历(非递归)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()){
            while (root != null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            resultList.add(root.val);
            root = root.right;
        }
        return resultList;
    }


    public static void main(String[] args) {

    }
}
