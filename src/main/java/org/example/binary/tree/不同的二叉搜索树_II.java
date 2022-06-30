package org.example.binary.tree;


import java.util.LinkedList;
import java.util.List;

public class 不同的二叉搜索树_II {

    /**
     * 95. 不同的二叉搜索树 II
     * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new LinkedList<>();
        }

        return generateTrees(1, n);
    }


    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> treeNodeList = new LinkedList<>();
        if (start > end){
            treeNodeList.add(null);
            return treeNodeList;
        }

        for (int i = start; i <= end; i++){

            //获取所有可行的左子树集合
            List<TreeNode> leftTreeNodeList = generateTrees(start, i-1);

            //获取所有可行的右子树集合
            List<TreeNode> rightTreeNodeList = generateTrees(i+1, end);


            for (TreeNode leftTreeNode : leftTreeNodeList){
                for (TreeNode rightTreeNode : rightTreeNodeList) {
                    TreeNode currentTreeNode = new TreeNode(i);
                    currentTreeNode.left = leftTreeNode;
                    currentTreeNode.right = rightTreeNode;
                    treeNodeList.add(currentTreeNode);
                }
            }
        }
        return treeNodeList;
    }

    public static void main(String[] args) {

    }
}
