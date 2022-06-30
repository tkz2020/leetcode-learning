package org.example.linked.list;

public class 给单链表加一 {

    /**
     * NC189 给单链表加一
     * @param head
     * @return
     */
    public ListNode plusOne(ListNode head) {
        if (head == null){
            return head;
        }

        //反转链表
        ListNode listNode1 = reverseList(head);
        ListNode listNode2 = new ListNode(1);

        ListNode first = null, last = null;
        ListNode tmp1 = listNode1;
        ListNode tmp2 = listNode2;
        int tmp = 0;
        while (tmp1 != null || tmp2 != null){
            int m = tmp1 != null ? tmp1.val : 0;
            int n = tmp2 != null ? tmp2.val : 0;
            tmp = m + n + tmp;
            ListNode node = new ListNode(tmp % 10);
            if (first == null && last == null){
                first = last = node;
            } else {
                last.next = node;
                last = last.next;
            }
            tmp /= 10;
            if (tmp1 != null){
                tmp1 = tmp1.next;
            }

            if (tmp2 != null){
                tmp2 = tmp2.next;
            }
        }

        if (tmp > 0){
            last.next = new ListNode(tmp);
        }

        return reverseList(first);
    }


    public ListNode reverseList(ListNode head){
        if (head == null){
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {

    }
}
