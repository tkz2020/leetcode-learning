package org.example.linked.list;

public class 链表排序_归并排序 {

    /**
     * 链表的归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }


    public ListNode sortList(ListNode head, ListNode tail){
        if (head == null){
            return head;
        }

        if (head.next == tail){
            head.next = null;
            return head;
        }

        //寻找链表的中间节点
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l1 = sortList(head, slow);
        ListNode l2 = sortList(slow, tail);

        //合并两个链表
        return merge(l1, l2);
    }


    /**
     * 合并两个链表，并且从小到大排序
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge(ListNode l1, ListNode l2){
        if (l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }

        ListNode dynamicListNode = new ListNode(-1);
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode tmp = dynamicListNode;
        while (tmp1 != null && tmp2 != null){
            if (tmp1.val < tmp2.val){
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }

        if (tmp1 != null){
            tmp.next = tmp1;
        }

        if (tmp2 != null){
            tmp.next = tmp2;
        }
        return dynamicListNode.next;
    }


    public static void main(String[] args) {

    }
}
