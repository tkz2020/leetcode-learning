package org.example.binary.tree;

import java.util.*;

public class 二叉树每层的最大值 {


    /**
     * 剑指 Offer II 044. 二叉树每层的最大值
     * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
     *
     * 示例1：
     * 输入: root = [1,3,2,5,3,null,9]
     * 输出: [1,3,9]
     *
     * 示例2：
     * 输入: root = [1,2,3]
     * 输出: [1,3]
     *
     * 示例3：
     * 输入: root = [1]
     * 输出: [1]
     *
     * 示例4：
     * 输入: root = [1,null,2]
     * 输出: [1,2]
     *
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++){
                TreeNode tmp = deque.poll();
                max = Math.max(tmp.val, max);
                if (tmp.left != null){
                    deque.offer(tmp.left);
                }

                if (tmp.right != null){
                    deque.offer(tmp.right);
                }
            }
            resultList.add(max);
        }
        return resultList;
    }

    public static void main(String[] args) {

    }
}
