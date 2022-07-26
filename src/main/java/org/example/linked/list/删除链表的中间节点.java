package org.example.linked.list;

public class 删除链表的中间节点 {

    /**
     * https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/
     * @param head
     * @return
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head == null){
            return head;
        }

        ListNode dynamic = new ListNode(-1, head);
        ListNode pre = dynamic;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            pre = pre.next;
        }

        pre.next = slow.next;
        return dynamic.next;
    }

    public static void main(String[] args) {

    }
}
