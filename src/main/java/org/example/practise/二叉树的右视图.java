package org.example.practise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的右视图 {

    public List<Integer> rightSideView(TreeNode root) {
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
            result.add(res.get(res.size() - 1));
        }
        return result;
    }


}
