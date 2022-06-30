package org.example.linked.list;

public class 删除链表的节点 {


    /**
     * NC289 删除链表的节点
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode (ListNode head, int val) {
        if (head == null){
            return head;
        }

        ListNode dynamic = new ListNode(-1);
        dynamic.next = head;
        ListNode pre = dynamic;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == val){
                break;
            }
            cur = cur.next;
            pre = pre.next;
        }

        pre.next = cur.next;
        return dynamic.next;
    }


    public static void main(String[] args) {

    }
}
