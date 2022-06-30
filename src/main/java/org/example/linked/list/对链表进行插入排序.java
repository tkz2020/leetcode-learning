package org.example.linked.list;

public class 对链表进行插入排序 {


    public ListNode insertionSortList (ListNode head) {
        if (head == null){
            return null;
        }

        ListNode dynamic = new ListNode(0);
        dynamic.next = head;
        ListNode lastSorted = head;
        ListNode cur = head.next;
        while (cur != null){
            if (lastSorted.val <= cur.val){
                lastSorted = lastSorted.next;
            } else {
                ListNode pre = dynamic;
                while (pre.next.val <= cur.val){
                    pre = pre.next;
                }
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastSorted.next;
        }
        return dynamic.next;
    }

    public static void main(String[] args) {

    }
}
