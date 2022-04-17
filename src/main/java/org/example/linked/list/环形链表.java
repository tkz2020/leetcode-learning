package org.example.linked.list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 环形链表 {


    /**
     * 环形链表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head){
        ListNode first = head;
        ListNode slow = head;
        while (first != null && first.next != null){
            first = first.next.next;
            slow = slow.next;
            if (first == slow){
                return true;
            }
        }
        return false;
    }


    public boolean hasCycle1(ListNode head){
        if (head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow){
            if (fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }


    public boolean hasCycle2(ListNode head){
        if (head == null || head.next == null){
            return false;
        }

        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
