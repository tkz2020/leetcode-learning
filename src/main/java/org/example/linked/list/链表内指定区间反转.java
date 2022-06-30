package org.example.linked.list;

import java.util.HashMap;
import java.util.Map;

public class 链表内指定区间反转 {

    /**
     * 链表指定区间反转
     * https://www.nowcoder.com/practice/b58434e200a648c589ca2063f1faf58c?tpId=196&tqId=37060&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=580&title=
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween (ListNode head, int m, int n){
        if (head == null){
            return head;
        }

        if (m > n){
            return head;
        }

        ListNode dynamic = new ListNode(-1);
        dynamic.next = head;
        ListNode cur = dynamic;
        for (int i = 1; i < m; i++){
            cur = cur.next;
        }

        ListNode middleHead = cur.next;
        ListNode tmpMiddleHead = middleHead;
        for (int i = 1; i <= n-m; i++){
            tmpMiddleHead = tmpMiddleHead.next;
        }

        ListNode tmp = tmpMiddleHead.next;
        tmpMiddleHead.next = null;
        ListNode newList = reverseList(middleHead);
        //前半段相连接
        cur.next = newList;

        middleHead.next = tmp;

        return dynamic.next;
    }


    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
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
        Map<Integer, Integer> map = new HashMap<>();
        map.containsValue(1);
    }
}
