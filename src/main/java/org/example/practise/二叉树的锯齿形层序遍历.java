package org.example.practise;

import java.util.*;

public class 二叉树的锯齿形层序遍历 {

    /**
     * 103. 二叉树的锯齿形层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> resultList = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean flag = true;
        while (!deque.isEmpty()){
            List<Integer> resList = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++){
                TreeNode node = deque.poll();

                if (flag){
                    resList.add(node.val);
                } else {
                    resList.add(0, node.val);
                }

                if (node.left != null){
                    deque.offer(node.left);
                }

                if (node.right != null){
                    deque.offer(node.right);
                }
            }
            resultList.add(resList);
            flag = !flag;
        }
        return resultList;
    }


    public static void main(String[] args) {

    }
}
