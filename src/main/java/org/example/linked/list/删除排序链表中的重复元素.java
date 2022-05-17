package org.example.linked.list;

public class 删除排序链表中的重复元素 {

    /**
     * 83. 删除排序链表中的重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode curListNode = head;
        while (curListNode.next != null){
            if (curListNode.val == curListNode.next.val){
                curListNode.next = curListNode.next.next;
            } else {
                curListNode = curListNode.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {

    }
}
