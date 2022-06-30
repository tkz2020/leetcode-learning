package org.example.linked.list;

public class 两个链表的第一个公共节点 {

    /**
     * 剑指 Offer 52. 两个链表的第一个公共节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }

        ListNode tmp1 = headA;
        ListNode tmp2 = headB;
        while (tmp1 != tmp2){
            tmp1 = tmp1 != null ? tmp1.next : headB;
            tmp2 = tmp2 != null ? tmp2.next : headA;
        }
        return tmp1;
    }


    public static void main(String[] args) {

    }
}
