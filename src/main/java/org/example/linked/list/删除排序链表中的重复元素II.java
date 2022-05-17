package org.example.linked.list;

public class 删除排序链表中的重复元素II {

    /**
     * 82. 删除排序链表中的重复元素 II
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dynamicListNode = new ListNode(-1, head);
        ListNode curListNode = dynamicListNode;
        while (curListNode.next != null && curListNode.next.next != null){
            if (curListNode.next.val == curListNode.next.next.val){
                int x = curListNode.next.val;
                while (curListNode.next != null && curListNode.next.val == x){
                    curListNode.next = curListNode.next.next;
                }
            } else {
                curListNode = curListNode.next;
            }
        }

        return dynamicListNode.next;
    }


    public static void main(String[] args) {

    }
}
