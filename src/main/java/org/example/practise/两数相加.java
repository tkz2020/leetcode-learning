package org.example.practise;

public class 两数相加 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }

        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode head = null, tail = null;
        int tmp = 0;
        while (tmp1 != null || tmp2 != null){
            int a = tmp1 != null ? tmp1.val : 0;
            int b = tmp2 != null ? tmp2.val : 0;
            int sum = a + b + tmp;
            ListNode node = new ListNode(sum % 10);
            if (head == null && tail == null){
                head = tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            tmp = sum / 10;
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

    }
}
