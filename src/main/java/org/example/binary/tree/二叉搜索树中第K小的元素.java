package org.example.binary.tree;

import java.util.*;

public class 二叉搜索树中第K小的元素 {

    /**
     * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> resultList = new ArrayList<>();
        middleDfs(root, resultList);
        return resultList.get(k-1);
    }


    /**
     * 二叉树的中序遍历
     * @param root
     * @param resultList
     */
    public void middleDfs(TreeNode root, List<Integer> resultList){
        if (root == null){
            return;
        }

        middleDfs(root.left, resultList);
        resultList.add(root.val);
        middleDfs(root.right, resultList);
    }


    public List<Integer> middleDfs(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (!deque.isEmpty() || root != null){
            while (root != null){
                deque.push(root.left);
                root = root.left;
            }
            root = deque.pop();
            resultList.add(root.val);
            root = root.right;
        }
        return resultList;
    }


    /**
     * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
     * 大根堆实现
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest1(TreeNode root, int k){
        PriorityQueue<TreeNode> queue = new PriorityQueue<>((TreeNode o1, TreeNode o2) -> o2.val - o1.val);
        dfs(root, queue, k);
        return queue.peek().val;
    }


    public void dfs(TreeNode root, PriorityQueue<TreeNode> queue, int k){
        if (root == null){
            return;
        }

        if (queue.size() < k){
            queue.offer(root);
        } else {
            if (root.val < queue.peek().val){
                queue.poll();
                queue.offer(root);
            }
        }

        if (root.left != null){
            dfs(root.left, queue, k);
        }

        if (root.right != null){
            dfs(root.right, queue, k);
        }
    }



    public static void main(String[] args) {

    }
}
