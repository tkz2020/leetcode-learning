package org.example.binary.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 前序遍历的顺序：根节点--->左节点--->右节点
 */
public class 二叉树的前序遍历 {

    /**
     * 二叉树的前序遍历(递归)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        preorderDfs(root, resultList);
        return resultList;
    }


    /**
     * 递归前序遍历
     * @param root
     * @param resultList
     */
    private void preorderDfs(TreeNode root, List<Integer> resultList){
        if (root == null){
            return;
        }

        resultList.add(root.val);
        preorderDfs(root.left, resultList);
        preorderDfs(root.right, resultList);
    }


    /**
     * 二叉树的前序遍历(非递归)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        while (!deque.isEmpty() || node != null){
            while (node != null){
                resultList.add(node.val);
                deque.push(node);
                node = node.left;
            }
            node = deque.pop();
            node = node.right;
        }
        return resultList;
    }



    public static void main(String[] args) {

    }
}
