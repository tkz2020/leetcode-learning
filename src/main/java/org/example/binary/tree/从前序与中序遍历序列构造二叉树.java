package org.example.binary.tree;


import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树 {


    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        if (preLen != inLen){
            return null;
        }

        //用HashMap保存中序遍历每个元素的位置，方便快速查找到根节点的在中序遍历中的位置。
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLen; i++){
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLen - 1, 0, inLen - 1, map);
    }


    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int inLeft, int inRight,
                               Map<Integer, Integer> map){

        if (preRight < preLeft || inRight < inLeft){
            return null;
        }

        //获取当前树的根节点
        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);
        int pIndex = map.get(rootValue);

        root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft, inLeft, pIndex - 1, map);
        root.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight, pIndex + 1, inRight, map);
        return root;
    }

    public static void main(String[] args) {

    }
}
