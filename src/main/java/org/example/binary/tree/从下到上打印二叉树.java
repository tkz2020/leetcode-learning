package org.example.binary.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 从下到上打印二叉树 {

    /**
     * NC224 从下到上打印二叉树
     * @param root
     * @return
     */
    public int[][] levelOrderBottom (TreeNode root) {
        if (root == null){
            return null;
        }

        List<List<Integer>> resultList = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            List<Integer> recList = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++){
                TreeNode node = deque.poll();
                recList.add(node.val);

                if (node.left != null){
                    deque.offer(node.left);
                }

                if (node.right != null){
                    deque.offer(node.right);
                }
            }
            resultList.add(recList);
        }

        int[][] num = new int[resultList.size()][];
        int index = 0;
        for (int i = resultList.size() - 1; i >= 0; i--){
            List<Integer> list = resultList.get(i);
            int[] tmp = new int[list.size()];
            for (int j = 0; j < list.size(); j++){
                tmp[j] = list.get(j);
            }
            num[index++] = tmp;
        }
        return num;
    }

}
