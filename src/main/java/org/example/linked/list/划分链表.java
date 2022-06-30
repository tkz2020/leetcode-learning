package org.example.linked.list;

public class 划分链表 {


    /**
     * NC23 划分链表
     * @param head
     * @param x
     * @return
     */
    public ListNode partition (ListNode head, int x) {
        if (head == null){
            return head;
        }

        //小于x的值拼接到链表dynamic1的后面
        ListNode dynamic1 = new ListNode(-1);
        ListNode tmp1 = dynamic1;

        //大于等于x的值拼接到dynamic2的后面
        ListNode dynamic2 = new ListNode(-2);
        ListNode tmp2 = dynamic2;
        ListNode tmp = head;
        while (tmp != null){
            ListNode node = new ListNode(tmp.val);
            if (tmp.val < x){
                tmp1.next = node;
                tmp1 = tmp1.next;
            } else {
                tmp2.next = node;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }

        dynamic1.next = dynamic2.next;
        return dynamic1.next;
    }

    public static void main(String[] args) {

    }
}
