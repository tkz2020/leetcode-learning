package org.example.binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 二叉搜索树的第k个节点 {

    /**
     * NC81 二叉搜索树的第k个节点
     * @param proot
     * @param k
     * @return
     */
    public int KthNode (TreeNode proot, int k) {
        List<Integer> resultList = new ArrayList<>();
        dfs(proot, resultList);

        return resultList.get(k-1);
    }

    public void dfs(TreeNode root, List<Integer> resultList){
        if (root == null){
            return;
        }

        dfs(root.left, resultList);
        resultList.add(root.val);
        dfs(root.right, resultList);
    }

    public static void main(String[] args) {

    }
}
