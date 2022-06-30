package org.example.binary.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的层平均值 {

    /**
     * 637. 二叉树的层平均值
     * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
     *
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[3.00000,14.50000,11.00000]
     * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
     * 因此返回 [3, 14.5, 11] 。
     *
     * 示例 2:
     * 输入：root = [3,9,20,15,7]
     * 输出：[3.00000,14.50000,11.00000]
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Double> resultList = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            List<Double> result = new ArrayList<>();
            int size = deque.size();
            double sum = 0;
            for (int i = 0; i < size; i++){
                TreeNode tmp = deque.poll();
                sum += tmp.val;
                if (tmp.left != null){
                    deque.offer(tmp.left);
                }

                if (tmp.right != null){
                    deque.offer(tmp.right);
                }
            }
            resultList.add(sum / size);
        }
        return resultList;
    }

    public static void main(String[] args) {

    }
}
