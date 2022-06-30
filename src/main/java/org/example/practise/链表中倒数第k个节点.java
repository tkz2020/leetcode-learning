package org.example.practise;

public class 链表中倒数第k个节点 {

    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode dynamicListNode = new ListNode(-1, head);
        ListNode tmp = dynamicListNode;

        int length = getListLength(head);
        for (int i = 1; i < length - k + 1; i++){
            tmp = tmp.next;
        }
        return tmp.next;
    }

    /**
     * 获取当前聊表的长度
     * @param head
     * @return
     */
    public int getListLength(ListNode head){
        if (head == null){
            return 0;
        }

        int length = 0;
        ListNode cur = head;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }


    public ListNode getKthFromEnd1(ListNode head, int k) {
        if (head == null){
            return head;
        }

        ListNode dynamic = new ListNode(-1, head);
        ListNode slow = dynamic, fast = dynamic;
        for (int i = 1; i <= k; i++){
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {

    }

}
