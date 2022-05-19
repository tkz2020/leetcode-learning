package org.example.linked.list;

import java.util.HashSet;
import java.util.Set;

public class 链表相交 {

    /**
     * 获取两个链表的相交节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }

        Set<ListNode> visited = new HashSet<>();
        ListNode curA = headA;
        while (curA != null){
            visited.add(curA);
            curA = curA.next;
        }

        ListNode curB = headB;
        while (curB != null){
            if (visited.contains(curB)){
                return curB;
            }
            curB = curB.next;
        }
        return null;
    }


    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB){
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }


    public static void main(String[] args) {

    }
}
