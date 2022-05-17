package org.example.linked.list;

public class 旋转链表 {

    /**
     * 61. 旋转链表
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0){
            return head;
        }

        //获取当前链表的长度
        ListNode curListNode = head;
        int listNodeLength = 1;
        //todo 这里需要判断curListNode.next是否为空
        while (curListNode.next != null){
            listNodeLength++;
            curListNode = curListNode.next;
        }

        k = k % listNodeLength;
        curListNode.next = head;
        curListNode = head;

        //获取反转后链表新的起点
        int index = listNodeLength - k;

        for (int i = 1; i < index; i++){
            curListNode = curListNode.next;
        }

        //新的尾部
        ListNode tail = curListNode;
        //新的头部
        head = curListNode.next;
        //断开尾部的后驱节点，把环断开
        tail.next = null;
        return head;
    }


    public static void main(String[] args) {

    }
}
