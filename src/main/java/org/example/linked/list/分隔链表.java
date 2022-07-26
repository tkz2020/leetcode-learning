package org.example.linked.list;

public class 分隔链表 {

    /**
     * https://leetcode.cn/problems/split-linked-list-in-parts/
     * @param head
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        while (cur != null){
            length++;
            cur = cur.next;
        }

        int q = length / k, r = length % k;
        ListNode[] result = new ListNode[k];
        ListNode tmp = head;
        for (int i = 0; i < k && tmp != null; i++){
            result[i] = tmp;
            int partSize = q + (i < r ? 1 : 0);
            for (int j = 1; j < partSize; j++){
                tmp = tmp.next;
            }
            ListNode next = tmp.next;
            tmp.next = null;
            tmp = next;
        }
        return  result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(10);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;

        int k = 3;
        分隔链表 ss = new 分隔链表();
        ss.splitListToParts(l1, k);
    }
}
