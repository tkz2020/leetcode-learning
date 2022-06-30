package org.example.binary.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树最底层最左边的值 {

    /**
     * 剑指 Offer II 045. 二叉树最底层最左边的值
     * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
     *
     * 假设二叉树中至少有一个节点。
     *
     * 示例 1:
     * 输入: root = [2,1,3]
     * 输出: 1
     *
     * 示例 2:
     * 输入: [1,2,3,4,null,5,6,null,null,7]
     * 输出: 7
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {

        List<List<Integer>> resultList = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode tmp = deque.poll();
                result.add(tmp.val);
                if (tmp.left != null){
                    deque.offer(tmp.left);
                }

                if (tmp.right != null){
                    deque.offer(tmp.right);
                }
            }
            resultList.add(result);
        }
        List<Integer> list = resultList.get(resultList.size() - 1);
        return list.get(0);
    }

    public static void main(String[] args) {

    }
}
