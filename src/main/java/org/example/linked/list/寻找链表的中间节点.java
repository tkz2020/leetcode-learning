package org.example.linked.list;

public class 寻找链表的中间节点 {

    /**
     * 快慢指针查询链表的中间节点
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == null ? slow : slow.next;
    }


    /**
     * 寻找链表的中间节点
     * @param head
     * @return
     */
    public ListNode middleNode1(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode listNode7 = new ListNode(7);
        ListNode listNode6 = new ListNode(6, listNode7);
        ListNode listNode5 = new ListNode(5, listNode6);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode = new ListNode(1, listNode2);
        寻找链表的中间节点 ss = new 寻找链表的中间节点();
        System.out.println(ss.middleNode1(listNode).val);
    }
}
