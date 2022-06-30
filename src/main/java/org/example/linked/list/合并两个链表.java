package org.example.linked.list;

public class 合并两个链表 {


    /**
     * 1669. 合并两个链表
     * https://leetcode.cn/problems/merge-in-between-linked-lists/
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if (list1 == null || list2 == null){
            return list1 == null ? list2 : list1;
        }

        ListNode dynamic = new ListNode(-1, list1);
        ListNode cur = dynamic;
        for (int i = 0; i < a; i++){
            cur = cur.next;
        }

        ListNode right = cur.next;
        for (int i = 1; i <= b - a; i++){
            right = right.next;
        }

        //指向最后的链表
        ListNode tmp = right.next;
        //把链表断了
        cur.next = null;
        right.next = null;

        ListNode cur1 = list2;
        while (cur1 != null){
            cur1 = cur1.next;
        }

        cur.next = list2;
        cur1.next = tmp;
        return list1;
    }

    public static void main(String[] args) {

    }
}
