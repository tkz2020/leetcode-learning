package org.example.binary.tree;

public class 二叉搜索树与双向链表 {

    /**
     * BM30 二叉搜索树与双向链表
     * @param pRootOfTree
     * @return
     */
    //头节点
    public TreeNode head = null;
    //中序遍历当前值的上一位，初始为最小值
    public TreeNode pre = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }

        //遍历到最左节点
        Convert(pRootOfTree.left);

        if (pre == null){
            head = pRootOfTree;
            pre = pRootOfTree;
        } else {
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pRootOfTree;
        }

        Convert(pRootOfTree.right);
        return head;
    }


    public static void main(String[] args) {

    }
}
