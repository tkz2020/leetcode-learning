package org.example.permutations;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径 {


    /**
     * 257. 二叉树的所有路径
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<String> pathList = new ArrayList<>();
        dfs(root, pathList, "");
        return pathList;
    }


    public void dfs(TreeNode root, List<String> res, String path){
        if (root == null){
            return;
        }

        StringBuilder sb = new StringBuilder(path);
        sb.append(String.valueOf(root.val));
        if (root.left == null && root.right == null){
            res.add(sb.toString());
        } else {
            sb.append("->");
            dfs(root.left, res, sb.toString());
            dfs(root.right, res, sb.toString());
        }
    }


    public static void main(String[] args) {

    }
}
