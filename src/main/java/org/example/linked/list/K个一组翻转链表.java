package org.example.linked.list;

public class K个一组翻转链表 {

    /**
     * K个一组反转链表
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 0){
            return head;
        }

        ListNode dynamic = new ListNode(-1, head);
        ListNode pre = dynamic;
        ListNode tail = dynamic;
        while (tail.next != null){
            for (int i = 1; i <= k; i++){
                if (tail != null){
                    tail = tail.next;
                }
            }

            // 如果 tail==null，即需要翻转的链表的节点个数小于k个，不执行翻转
            if (tail == null){
                break;
            }

            //指向前一段链表的头节点
            ListNode start = pre.next;

            //next指向下一段链表
            ListNode next = tail.next;

            //断开链表
            tail.next = null;
            //反转链表
            pre.next = reverse(start);
            //和下一段链表相互连接
            start.next = next;

            //重置pre和tail指针到下一段链表
            pre = start;
            tail = start;
        }
        return dynamic.next;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        if (head == null){
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
