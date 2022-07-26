package org.example.linked.list;

public class 奇位升偶位降链表排序 {


    /**
     * 奇位升序，偶位降序排列
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head){
        if (head == null){
            return head;
        }

        ListNode oddHead = null, oddTail = null;
        ListNode evenHead = null, evenTail = null;
        ListNode cur = head;
        int index = 1;
        while (cur != null){
            if (index % 2 == 0){
                if (evenHead == null && evenTail == null){
                    evenHead = evenTail = cur;
                } else {
                    evenTail.next = cur;
                    evenTail = evenTail.next;
                }
            } else {
                if (oddHead == null && oddTail == null){
                    oddHead = oddTail = cur;
                } else {
                    oddTail.next = cur;
                    oddTail = oddTail.next;
                }
            }
            index++;
        }

        //翻转偶数位链表节点的顺序
        ListNode evenList = reverseList(evenHead);
        //合并两个链表
        return mergeList(oddHead,  evenList);
    }

    /**
     * 链表反转
     * @param head
     * @return
     */
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

    /**
     * 链表合并
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeList(ListNode l1, ListNode l2){
        if (l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }

        ListNode tmp1 = l1, tmp2 = l2;
        ListNode dynamic = new ListNode(-1);
        ListNode tmp = dynamic;
        while (tmp1 != null && tmp2 != null){
            tmp.next = tmp1;
            tmp1 = tmp1.next;
            tmp = tmp.next;

            tmp.next = tmp2;
            tmp2 = tmp2.next;
            tmp = tmp.next;
        }

        while (tmp1 != null){
            tmp.next = tmp1;
        }

        while (tmp2 != null){
            tmp.next = tmp2;
        }
        return dynamic.next;
    }


    public static void main(String[] args) {

    }
}
