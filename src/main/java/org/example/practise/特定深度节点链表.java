package org.example.practise;

import org.example.practise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 特定深度节点链表 {

    /**
     * 面试题 04.03. 特定深度节点链表
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null){
            return null;
        }

        List<List<Integer>> resultList = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(tree);
        while (!deque.isEmpty()){
            List<Integer> resList = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++){
                TreeNode node = deque.poll();
                resList.add(node.val);

                if (node.left != null){
                    deque.offer(node.left);
                }

                if (node.right != null){
                    deque.offer(node.right);
                }
            }
            resultList.add(resList);
        }

        if (resultList.size() == 0){
            return null;
        }

        ListNode[] resultListNode = new ListNode[resultList.size()];
        for (int i = 0; i < resultList.size(); i++){
            ListNode head = null, tail = null;
            for (Integer result : resultList.get(i)){
                if (head == null && tail == null){
                    head = tail = new ListNode(result);
                } else {
                    tail.next = new ListNode(result);
                    tail = tail.next;
                }
            }
            resultListNode[i] = head;
        }
        return resultListNode;
    }



    public static void main(String[] args) {

    }
}
