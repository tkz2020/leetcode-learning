package org.example.binary.tree;

import java.util.ArrayList;
import java.util.List;

public class 二叉树展开为链表 {

    /**
     * NC332 二叉树展开为单链表
     * @param root
     */
    public void expandTree (TreeNode root) {
        if (root == null){
            return;
        }

        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 1; i < list.size(); i++){
            TreeNode preNode = list.get(i-1);
            TreeNode cur = list.get(i);
            preNode.right = cur;
            preNode.left = null;
        }
    }


    public void dfs(TreeNode root, List<TreeNode> list){
        if (root == null){
            return;
        }

        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }

    public static void main(String[] args) {

    }
}
