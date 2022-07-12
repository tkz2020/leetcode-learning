package org.example.linked.list;

public class 链表中倒数第k个节点 {

    /**
     * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
     * 链表中倒数第k个节点----> 快慢指针
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k){
        if (head == null || k == 0){
            return head;
        }

        ListNode dynamic = new ListNode(-1);
        dynamic.next = head;
        ListNode fast = dynamic, slow = dynamic;
        for (int i = 1; i <= k + 1; i++){
            fast = fast.next;
        }


        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;
        return tmp;
    }

    public static void main(String[] args) {

    }
}
