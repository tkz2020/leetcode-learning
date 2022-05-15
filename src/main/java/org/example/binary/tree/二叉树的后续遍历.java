package org.example.binary.tree;

import java.util.*;

/**
 * 二叉树后序遍历：左子树 ---> 右子树 ---> 根结点
 */
public class 二叉树的后续遍历 {

    /**
     * 二叉树的后序遍历(递归)
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


    /**
     * 二叉树的后续遍历(非递归)
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> stack= new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev){
                resultList.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return resultList;
    }


    public static void main(String[] args) {

    }
}
