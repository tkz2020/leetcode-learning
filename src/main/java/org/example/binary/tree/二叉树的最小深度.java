package org.example.binary.tree;

import java.util.Collections;

public class 二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null){
            return 1;
        }

        int maxValue = Integer.MAX_VALUE;
        if (root.left != null){
            maxValue = Math.min(minDepth(root.left), maxValue);
        }

        if (root.right != null){
            maxValue = Math.min(minDepth(root.right), maxValue);
        }
        return maxValue + 1;
    }
}
