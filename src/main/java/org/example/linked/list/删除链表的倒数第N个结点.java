package org.example.linked.list;

public class 删除链表的倒数第N个结点 {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 示例 1：
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * 示例 2：
     * 输入：head = [1], n = 1
     * 输出：[]
     *
     * 示例 3：
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return head;
        }

        int listLength = getListLength(head);
        //新建一个动态节点，指向head节点，防止删除头节点。
        ListNode dynamicNode = new ListNode(-1, head);
        ListNode cur = dynamicNode;
        for (int i = 1; i < listLength - n + 1; i++){
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return dynamicNode.next;
    }


    /**
     * 删除链表中倒数第N个节点，先用快慢指针找到倒数第N个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null){
            return head;
        }

        //定义两个快慢指针
        ListNode dynamic = new ListNode(-1, head);
        ListNode fast = dynamic, slow = dynamic;
        for (int i = 1; i <= n+1; i++){
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dynamic.next;
    }


    private int getListLength(ListNode head){
        if (head == null){
            return 0;
        }

        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {

    }
}
