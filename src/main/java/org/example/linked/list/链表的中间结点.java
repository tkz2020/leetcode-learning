package org.example.linked.list;

public class 链表的中间结点 {

    /**
     * NC322 链表的中间结点
     * @param head
     * @return
     */
    public ListNode middleNode (ListNode head) {
        // write code here
        if (head == null){
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
