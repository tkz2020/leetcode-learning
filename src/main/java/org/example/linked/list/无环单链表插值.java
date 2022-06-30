package org.example.linked.list;

public class 无环单链表插值 {

    public ListNode insert (int[] A, int val) {
        if (A == null || A.length == 0){
            return null;
        }

        //数组转换为链表
        ListNode head = null, tail = null;
        for (int i = 0; i < A.length; i++){
            ListNode node = new ListNode(A[i]);
            if (head == null && tail == null){
                head = tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }
        tail.next = new ListNode(val);

        //对链表进行插入排序
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
