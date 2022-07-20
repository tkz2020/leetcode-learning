package org.example.binary.tree;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树的最近公共祖先 {

    /**
     * BM37 二叉搜索树的最近公共祖先
     * 二叉搜索树是一种特殊的二叉树，它的每个节点值大于它的左子节点，
     * 且大于全部左子树的节点值，小于它的右子节点，且小于全部右子树的节点值。
     * 因为二叉搜索树一定程度上算是一种排序的结构
     * @param root
     * @param p
     * @param q
     * @return
     */
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        List<Integer> leftPathList = getPath(root, p);
        List<Integer> rightPathList = getPath(root, q);

        int i = 0, leftLength = leftPathList.size();
        int j = 0, rightLength = rightPathList.size();
        int result = 0;
        while (i < leftLength && j < rightLength){
            //最后一个相同的节点就是最近公共祖先
            if (leftPathList.get(i).equals(rightPathList.get(j))){
                result = leftPathList.get(i);
            }
            i++;
            j++;
        }
        return result;
    }


    /**
     * 获取根节点到目标节点的路径
     * @param root
     * @param target
     * @return
     */
    public List<Integer> getPath(TreeNode root, int target){
        List<Integer> pathList = new ArrayList<>();
        TreeNode node = root;
        while (node.val != target){
            pathList.add(node.val);
            if (node.val < target){
                node = node.right;
            } else {
                node = node.left;
            }
        }
        pathList.add(node.val);
        return pathList;
    }


    /**
     * BM37 二叉搜索树的最近公共祖先（递归解决）
     * @param root
     * @param p
     * @param q
     * @return
     */
    public int lowestCommonAncestor1 (TreeNode root, int p, int q) {
        if (root == null){
            return -1;
        }

        if ((p >= root.val && q <= root.val) || (p <= root.val && q >= root.val)){
            return root.val;
        } else if (p <= root.val && q <= root.val){
            return lowestCommonAncestor1(root.right, p, q);
        } else {
            return lowestCommonAncestor1(root.right, p, q);
        }
    }


    /**
     * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null){
            return null;
        }

        if (left == null){
            return right;
        }

        if (right == null){
            return left;
        }
        return root;
    }


    public static void main(String[] args) {

    }
}
