package org.example.practise;

public class 翻转链表 {


    private ListNode reverseList(ListNode head){
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
