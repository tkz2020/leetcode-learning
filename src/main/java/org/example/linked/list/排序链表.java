package org.example.linked.list;

public class 排序链表 {

    /**
     * 148. 排序链表
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return null;
    }


    public ListNode sortList(ListNode head, ListNode tail){
        if (head == null){
            return head;
        }

        return null;
    }

    private ListNode mergeListNode(ListNode head1, ListNode head2){
        if (head1 == null || head2 == null){
            return head1 == null ? head1 : head2;
        }

        ListNode dynamicListNode = new ListNode(-1);
        ListNode tmp1 = head1;
        ListNode tmp2 = head2;
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

        if (tmp1 != null){
            tmp.next = tmp1;
        } else if (tmp2 != null){
            tmp.next = tmp2;
        }
        return dynamicListNode.next;
    }

    public static void main(String[] args) {

    }
}
