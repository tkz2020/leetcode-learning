package org.example.linked.list;

public class 分割链表 {

    /**
     * https://leetcode.cn/problems/partition-list-lcci/
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;

        ListNode head1 = null, tail1 = null;
        ListNode head2 = null, tail2 = null;

        ListNode tmp = head;
        while (tmp != null){
            if (tmp.val < x){
                //这块需要重新new一个ListNode，不然拼接出来的链表是有问题的
                ListNode node = new ListNode(tmp.val);
                if (head1 == null && tail1 == null){
                    head1 = tail1 = node;
                } else {
                    tail1.next = node;
                    tail1 = tail1.next;
                }
            } else {
                ListNode node = new ListNode(tmp.val);
                if (head2 == null && tail2 == null){
                    head2 = tail2 = node;
                } else {
                    tail2.next = node;
                    tail2 = tail2.next;
                }
            }
            tmp = tmp.next;
        }

        //这块需要先判断一下head1和tail1是否为null，不为null的时候，才可以拼接head2
        if (head1 != null && tail1 != null){
            tail1.next = head2;
            return head1;
        } else {
            return head2;
        }
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        int x = 3;
        分割链表 ss = new 分割链表();
        ss.partition(listNode1, x);
    }
}
