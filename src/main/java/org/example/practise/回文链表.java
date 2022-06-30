package org.example.practise;

import java.util.ArrayList;
import java.util.List;

public class 回文链表 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }

        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list.add(cur.val);
            cur = cur.next;
        }

        int i = 0, j = list.size() - 1;
        while (i <= j){
            if (!list.get(i).equals(list.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
