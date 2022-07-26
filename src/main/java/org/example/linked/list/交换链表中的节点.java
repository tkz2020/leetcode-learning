package org.example.linked.list;

public class 交换链表中的节点 {


    /**
     * https://leetcode.cn/problems/swapping-nodes-in-a-linked-list/
     * @param head
     * @param k
     * @return
     */
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null){
            return head;
        }

        //正数第K个节点
        ListNode left = head;
        //倒数第K个节点
        ListNode right = head;
        for (int i = 1; i < k; i++){
            left = left.next;
        }

        ListNode cur = left;
        while (cur.next != null){
            cur = cur.next;
            right = right.next;
        }

        //交换两个节点的值
        int m = right.val;
        right.val = left.val;
        left.val = m;
        return head;
    }


    public ListNode swapNodes1(ListNode head, int k) {
        // 模拟指针，用来遍历链表
        ListNode cur = head;
        // 用来定位正数第k个节点
        ListNode first = head;
        // 用来定位倒数第k个节点
        ListNode last = head;
        // 用于节点的计数，和节点值的交换
        int count = 1;
        while (cur.next != null) {
            // 找到正数第k个节点
            if (count < k) {
                first = first.next;
                // 找到倒数第k个节点
            } else {
                last = last.next;
            }
            count++;
            cur = cur.next;
        }
        // 交换正数第k个节点和倒数第k个节点的值
        count = first.val;
        first.val = last.val;
        last.val = count;
        return head;
    }


    public static void main(String[] args) {

    }
}
