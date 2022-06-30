package org.example.linked.list;

import java.util.ArrayList;
import java.util.List;

public class 重排链表 {

    /**
     * 传统解法（LeetCode上通过，牛客网上超时）
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }

        //获取链表的中结点
        ListNode middle = middleListNode(head);

        ListNode cur = head;
        while (cur != null){
            if (cur == middle){
                break;
            }
            cur = cur.next;
        }

        ListNode curNext = cur.next;
        cur.next = null;

        //反转链表的后半段
        ListNode tmp = reverseList(curNext);

        mergeListNode(head, tmp);
    }

    /**
     * 双指针
     * @param head
     */
    public void reorderList1(ListNode head){
        if (head == null || head.next == null){
            return;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list.add(cur);
            cur = cur.next;
        }

        int left = 0, right = list.size() - 1;
        while (left < right){
            list.get(left).next = list.get(right);
            left++;
            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next = null;
    }

    /**
     * 合并两个链表
     * @param listNode1
     * @param listNode2
     * @return
     */
    public ListNode mergeListNode(ListNode listNode1, ListNode listNode2){
        if (listNode1 == null || listNode2 == null){
            return listNode1 == null ? listNode2 : listNode1;
        }

        ListNode tmp1 = listNode1;
        ListNode tmp2 = listNode2;
        ListNode dynamic = new ListNode(-1);
        ListNode cur = dynamic;
        while (tmp1 != null && tmp2 != null){
            cur.next = tmp1;
            tmp1 = tmp1.next;
            cur = cur.next;

            cur.next = tmp2;
            tmp2 = tmp2.next;
            cur = cur.next;
        }

        if (tmp1 == null){
            cur.next = tmp2;
        }

        if (tmp2 == null){
            cur.next = tmp1;
        }

        return dynamic.next;
    }

    /**
     * 寻找链表的中结点
     * @param head
     * @return
     */
    public ListNode middleListNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
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

    public static void main(String[] args) {

    }
}
