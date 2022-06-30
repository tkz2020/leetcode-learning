package org.example.linked.list;

public class 排序奇升偶降链表 {

    /**
     * NC207 排序奇升偶降链表
     * @param head
     * @return
     */
    public ListNode sortLinkedList (ListNode head) {
        if (head == null){
            return head;
        }

        int index = 0;
        ListNode cur = head;
        ListNode oddHead = null, oddTail = null;
        ListNode evenHead = null, evenTail = null;
        while (cur != null){
            ListNode node = new ListNode(cur.val);
            if (index % 2 == 0){
                if (evenHead == null && evenTail == null){
                    evenHead = evenTail = node;
                } else {
                    evenTail.next = node;
                    evenTail = evenTail.next;
                }
            } else {
                if (oddHead == null && oddTail == null){
                    oddHead = oddTail = node;
                } else {
                    oddTail.next = node;
                    oddTail = oddTail.next;
                }
            }
            cur = cur.next;
            index++;
        }

        ListNode even = reverse(evenHead);
        return merge(oddHead, even);
    }

    public ListNode reverse(ListNode head){
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


    public ListNode merge(ListNode list1, ListNode list2){
        if (list1 == null || list2 == null){
            return list1 == null ? list2 : list1;
        }

        ListNode dynamicListNode = new ListNode(-1);
        ListNode tmp1 = list1;
        ListNode tmp2 = list2;
        ListNode tmp = dynamicListNode;
        while (tmp1 != null && tmp2 != null){
            if (tmp1.val > tmp2.val){
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            } else {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            }
            tmp = tmp.next;
        }

        if (tmp1 == null){
            tmp.next = tmp2;
        }

        if (tmp2 == null){
            tmp.next = tmp1;
        }
        return dynamicListNode.next;
    }

    public static void main(String[] args) {

    }

}
