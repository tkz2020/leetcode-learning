package org.example.practise;

public class 奇偶链表 {


    /**
     * 328. 奇偶链表
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        //保存偶数位的链表，避免链表断开之后，偶数的链表找不到
        ListNode evenListNode = head.next;
        ListNode odd = head;
        ListNode even = evenListNode;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenListNode;
        return head;
    }

    public static void main(String[] args) {

    }
}
