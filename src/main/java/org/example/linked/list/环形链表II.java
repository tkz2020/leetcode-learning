package org.example.linked.list;

import java.util.HashSet;
import java.util.Set;

public class 环形链表II {

    /**
     * https://leetcode.cn/problems/linked-list-cycle-ii/
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null){
            if (set.contains(cur)){
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
