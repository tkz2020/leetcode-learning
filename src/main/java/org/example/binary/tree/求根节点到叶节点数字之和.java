package org.example.binary.tree;

import java.util.ArrayList;
import java.util.List;

public class 求根节点到叶节点数字之和 {

    /**
     * https://leetcode.cn/problems/sum-root-to-leaf-numbers/
     * 递归+回溯
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }

        StringBuffer path = new StringBuffer();
        List<String> resultList = new ArrayList<>();
        dfs(root, path, resultList);
        int sum = 0;
        for (String result : resultList){
            sum += Integer.parseInt(result);
        }
        return sum;
    }

    /**
     * 递归+回溯 遍历二叉树，获取二叉树跟节点到叶子节点的所有值
     * @param root
     * @param path
     * @param resultList
     */
    public void dfs(TreeNode root, StringBuffer path, List<String> resultList){
        if (root == null){
            return;
        }

        path.append(root.val);
        if (root.left == null && root.right == null){
            resultList.add(new String(path));
        }

        dfs(root.left, path, resultList);
        dfs(root.right, path, resultList);
        path.deleteCharAt(path.length() - 1);
    }

    public static void main(String[] args) {

    }
}
