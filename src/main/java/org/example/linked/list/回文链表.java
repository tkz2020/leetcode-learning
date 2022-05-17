package org.example.linked.list;

import java.util.ArrayList;
import java.util.List;

public class 回文链表 {

    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return false;
        }

        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list.add(cur.val);
            cur = cur.next;
        }

        int i = 0;
        int j = list.size() - 1;
        boolean flag = false;
        while (i <= j){
            if (list.get(i) != list.get(j)){
                flag = true;
                break;
            }
            i++;
            j--;
        }

        if (flag){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(1, null);
        ListNode listNode3 = new ListNode(2, listNode4);
        ListNode listNode2 = new ListNode(1, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        回文链表 ss = new 回文链表();
        System.out.println(ss.isPalindrome(listNode1));
    }
}
