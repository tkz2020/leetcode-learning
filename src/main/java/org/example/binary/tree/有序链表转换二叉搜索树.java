package org.example.binary.tree;


import java.util.ArrayList;
import java.util.List;

public class 有序链表转换二叉搜索树 {

    /**
     * 109. 有序链表转换二叉搜索树
     * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }

        List<Integer> resultList = new ArrayList<>();
        while (head != null){
            resultList.add(head.val);
            head = head.next;
        }

        return sortedListToBST(resultList, 0, resultList.size() - 1);
    }


    public TreeNode sortedListToBST(List<Integer> resultList, int left, int right){
        if (left > right){
            return null;
        }

        int middle = (left + right) / 2;
        TreeNode root = new TreeNode(resultList.get(middle));
        root.left = sortedListToBST(resultList, left, middle - 1);
        root.right = sortedListToBST(resultList, middle + 1, right);
        return root;
    }



    public static void main(String[] args) {

    }
}
