package org.example.practise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树展开为链表 {

    /**
     * 114. 二叉树展开为链表
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }

        List<TreeNode> resultList = preTraverse(root);
        for (int i = 1; i < resultList.size(); i++){
            TreeNode prev = resultList.get(i-1);
            TreeNode cur = resultList.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }


    /**
     * 二叉树前序遍历
     * @return
     */
    public List<TreeNode> preTraverse(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        List<TreeNode> resultList = new ArrayList<>();
        TreeNode node = root;
        while (!deque.isEmpty() || node != null){
            while (node != null){
                resultList.add(node);
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
