package org.example.practise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的左视图 {

    /**
     * 199. 二叉树的右视图
     * @param root
     * @return
     */
    public List<Integer> leftSideView(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            List<Integer> res = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++){
                TreeNode treeNode = deque.poll();
                res.add(treeNode.val);
                if (treeNode.left != null){
                    deque.offer(treeNode.left);
                }

                if (treeNode.right != null){
                    deque.offer(treeNode.right);
                }
            }
            result.add(res.get(0));
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
