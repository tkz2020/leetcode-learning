package org.example.binary.tree;

import java.util.*;

public class 二叉树的层序遍历 {


    /**
     * 二叉树的层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        List<List<Integer>> resultList = new ArrayList<>();
        while (!deque.isEmpty()){
            List<Integer> res = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++){
                TreeNode node = deque.poll();
                res.add(node.val);
                if (node.left != null){
                    deque.offer(node.left);
                }

                if (node.right != null){
                    deque.offer(node.right);
                }
            }
            resultList.add(res);
        }
        return resultList;
    }

    public static void main(String[] args) {

    }
}
