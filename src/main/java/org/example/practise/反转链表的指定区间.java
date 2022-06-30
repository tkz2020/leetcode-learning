package org.example.practise;

public class 反转链表的指定区间 {

    /**
     * 92. 反转链表 II
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null){
            return null;
        }

        ListNode dynamicListNode = new ListNode(-1, head);
        ListNode cur = dynamicListNode;
        //找到指定区间链表的头节点
        for (int i = 1; i < left; i++){
            cur = cur.next;
        }

        //找到指定区间链表的尾节点
        ListNode rightNode = cur;
        for (int i = 0; i <= right - left; i++){
            rightNode = rightNode.next;
        }

        //指定区间链表的头节点
        ListNode leftNode = cur.next;
        //tmp指向的是right位置后面的链表
        ListNode tmp = rightNode.next;
        //切断链表
        cur.next = null;
        rightNode.next = null;

        //反转链表
        reverseList(leftNode);

        //连接链表
        cur.next = rightNode;
        leftNode.next = tmp;
        return dynamicListNode.next;
    }


    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }


    public static void main(String[] args) {

    }
}
