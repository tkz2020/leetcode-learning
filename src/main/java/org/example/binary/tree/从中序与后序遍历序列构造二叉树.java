package org.example.binary.tree;


import java.util.HashMap;
import java.util.Map;

public class 从中序与后序遍历序列构造二叉树 {

    /**
     * 106. 从中序与后序遍历序列构造二叉树
     * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        if (inLen != postLen){
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLen; i++){
            map.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postLen, 0, inLen, map);
    }


    private TreeNode buildTree(int[] postorder, int postLeft, int postRight, int inLeft, int inRight,
                               Map<Integer, Integer> map){

        if (postLeft > postRight || inLeft > inRight){
            return null;
        }

        int rootValue = postorder[postRight];
        TreeNode root = new TreeNode(rootValue);
        int inIndex = map.get(rootValue);

        root.left = buildTree(postorder, postLeft, inIndex - inLeft + postLeft - 1, inLeft, inIndex - 1, map);
        root.right = buildTree(postorder, inIndex - inLeft + postLeft, postRight - 1, inIndex + 1, inRight, map);
        return root;
    }


    public static void main(String[] args) {

    }
}
