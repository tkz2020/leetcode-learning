package org.example.binary.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class 二叉树最大宽度 {

    /**
     * https://leetcode.cn/problems/maximum-width-of-binary-tree/
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int result = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            result = Math.max(result, deque.peekLast().val - deque.peekFirst().val + 1);
            while (size-->0){
                TreeNode node = deque.poll();
                if (node.left != null){
                    node.left.val = node.val * 2 - 1;
                    deque.offer(node.left);
                }

                if (node.right != null){
                    node.right.val = node.val * 2;
                    deque.offer(node.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
