package org.example.practise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的前序遍历 {

    public List<Integer> preOrder(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        while (!deque.isEmpty() || node != null){
            while (node != null){
                resultList.add(node.val);
                deque.offerFirst(node);  //deque.push(node);
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
