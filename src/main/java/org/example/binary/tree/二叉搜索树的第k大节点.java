package org.example.binary.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉搜索树的第k大节点 {


    public int kthLargest(TreeNode root, int k) {
        List<Integer> resultList = new ArrayList<>();
        dfs(root, resultList);
        return resultList.get(resultList.size() - k);
    }


    public void dfs(TreeNode root, List<Integer> resultList){
        if (root == null){
            return;
        }

        dfs(root.left, resultList);
        resultList.add(root.val);
        dfs(root.right, resultList);
    }

    /**
     * 非递归实现二叉树的中序遍历
     * @param root
     * @return
     */
    public List<Integer> dfs1(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (!deque.isEmpty() || root != null){
            while (root != null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            resultList.add(root.val);
            root = root.right;
        }
        return resultList;
    }


    public static void main(String[] args) {

    }
}
