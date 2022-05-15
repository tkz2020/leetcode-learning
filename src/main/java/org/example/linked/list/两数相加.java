package org.example.linked.list;

public class 两数相加 {

    /**
     * 2. 两数相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }

        if (l2 == null){
            return l1;
        }

        ListNode head = null, tail = null;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        int tmp = 0;
        while (tmp1 != null || tmp2 != null){
            int a = tmp1 != null ? tmp1.val : 0;
            int b = tmp2 != null ? tmp2.val : 0;
            tmp = a + b + tmp;
            ListNode node = new ListNode(tmp % 10);
            if (head == null){
                head = tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            tmp = tmp / 10;
            if (tmp1 != null){
                tmp1 = tmp1.next;
            }
            if (tmp2 != null){
                tmp2 = tmp2.next;
            }
        }

        if (tmp > 0){
            tail.next = new ListNode(tmp);
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode listNode7 = new ListNode(9);
        ListNode listNode6 = new ListNode(9, listNode7);
        ListNode listNode5 = new ListNode(9, listNode6);
        ListNode listNode4 = new ListNode(9, listNode5);
        ListNode listNode3 = new ListNode(9, listNode4);
        ListNode listNode2 = new ListNode(9, listNode3);
        ListNode listNode1 = new ListNode(9, listNode2);

        ListNode l4 = new ListNode(9);
        ListNode l3 = new ListNode(9, l4);
        ListNode l2 = new ListNode(9, l3);
        ListNode l1 = new ListNode(9, l2);

        两数相加 ss = new 两数相加();
        ListNode listNode = ss.addTwoNumbers(listNode1, l1);
        PrintListNode.printListNode(listNode);
    }

}
