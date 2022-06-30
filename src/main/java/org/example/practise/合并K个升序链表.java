package org.example.practise;

import java.util.ArrayList;

public class 合并K个升序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }

        ListNode tmp = null;
        for (ListNode listNode : lists){
            tmp = mergeListNode(tmp, listNode);
        }
        return tmp;
    }


    public ListNode divideMerge(ArrayList<ListNode> list, int left, int right){
        if (left > right){
            return null;
        } else if (left == right){
            return list.get(left);
        }

        int middle = (left + right) / 2;
        return mergeListNode(divideMerge(list, left, middle), divideMerge(list, middle +1, right));
    }

    /**
     * 合并两个有序链表，从小到大
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeListNode(ListNode l1, ListNode l2){
        if (l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }

        ListNode dynamicListNode = new ListNode(-1);
        ListNode tmp = dynamicListNode;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        while (tmp1 != null && tmp2 != null){
            if (tmp1.val < tmp2.val){
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }

        if (tmp1 == null){
            tmp.next = tmp2;
        }

        if (tmp2 == null){
            tmp.next = tmp1;
        }
        return dynamicListNode.next;
    }

}
