package org.example.linked.list;

public class ListNode {

    int val;

    ListNode next;

    ListNode(int x){
        this.val = x;
        next = null;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }


}
