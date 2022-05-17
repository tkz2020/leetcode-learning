package org.example.linked.list;

public class 两两交换链表中的节点 {

    /**
     * 24. 两两交换链表中的节点
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dynamicListNode = new ListNode(-1, head);
        ListNode tmp = dynamicListNode;
        while (tmp.next != null && tmp.next.next != null){
            ListNode tmp1 = tmp.next;
            ListNode tmp2 = tmp.next.next;

            tmp.next = tmp2;
            tmp1.next = tmp2.next;
            tmp2.next = tmp1;
            tmp = tmp1;
        }
        return dynamicListNode.next;
    }


    /**
     * 两两交换链表中的节点(递归实现)
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs1(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {

    }
}
