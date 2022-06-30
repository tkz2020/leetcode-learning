package org.example.binary.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 判断是不是完全二叉树 {

    public boolean isCompleteTree (TreeNode root) {
        if (root == null){
            return true;
        }

        //这块不能用ArrayDeque，是因为ArrayDeque的offer方法是不能传入null的，所以会报空指针错误
        //LinkedList的offer方法是允许存储null值的。
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean isCompleteTree = false;
        while (!deque.isEmpty()){
            TreeNode node = deque.poll();

            if (node == null){
                isCompleteTree = true;
            } else {
                if (isCompleteTree){
                    return false;
                }
                deque.offer(node.left);
                deque.offer(node.right);
            }
        }
        return true;
    }
}
