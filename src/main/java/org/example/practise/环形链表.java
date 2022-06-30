package org.example.practise;

import java.util.HashSet;
import java.util.Set;

public class 环形链表 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }


    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }

        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
