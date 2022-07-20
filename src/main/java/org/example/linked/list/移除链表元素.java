package org.example.linked.list;

public class 移除链表元素 {

    /**
     * https://leetcode.cn/problems/remove-linked-list-elements/
     * 203. 移除链表元素
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }

        ListNode dynamic = new ListNode(-1);
        dynamic.next = head;
        ListNode tmp = dynamic;
        while (tmp != null){
            if (tmp.next.val == val){
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return dynamic.next;
    }

    public static void main(String[] args) {

    }
}
