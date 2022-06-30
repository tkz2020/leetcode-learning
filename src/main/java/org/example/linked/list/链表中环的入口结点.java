package org.example.linked.list;

import java.util.HashSet;
import java.util.Set;

public class 链表中环的入口结点 {

    /**
     * BM7 链表中环的入口结点
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode cur = pHead;
        Set<ListNode> visited = new HashSet<>();
        while (cur != null){
            if (visited.contains(cur)){
                return cur;
            } else {
                visited.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }


    public ListNode detectCycle(ListNode head){
        if (head == null || head.next == null){
            return null;
        }

        ListNode fast = head, slow = head;
        while (fast != null){
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next.next;
            } else {
                return null;
            }

            if (fast == slow){
                ListNode cur = head;
                while (cur != slow){
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }
        return null;
    }



    public static void main(String[] args) {

    }
}
