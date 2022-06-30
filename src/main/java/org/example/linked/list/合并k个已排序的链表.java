package org.example.linked.list;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 合并k个已排序的链表 {


    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return divideMerge(lists, 0, lists.size() - 1);
    }


    /**
     * 分治合并K个链表
     * @param lists
     * @param left
     * @param right
     * @return
     */
    public ListNode divideMerge(ArrayList<ListNode> lists, int left, int right){
        if (left == right){
            return lists.get(left);
        }

        if (left > right){
            return null;
        }

        int middle = (left + right) >> 1;
        return mergeTwoLists(divideMerge(lists, left, middle), divideMerge(lists, middle+1, right));
    }


    /**
     * 合并两个链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null){
            return list1 == null ? list2 : list1;
        }

        ListNode dynamicListNode = new ListNode(-1);
        ListNode tmp1 = list1;
        ListNode tmp2 = list2;
        ListNode tmp = dynamicListNode;
        while (tmp1 != null && tmp2 != null){
            if (tmp1.val > tmp2.val){
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            } else {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            }
            tmp = tmp.next;
        }

        if (tmp1 != null){
            tmp.next = tmp1;
        }

        if (tmp2 != null){
            tmp.next = tmp2;
        }
        return dynamicListNode.next;
    }


    /**
     * 合并K个有序链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0){
            return null;
        }

        //定义一个优先级队列
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);

        for (int i = 0; i < lists.size(); i++){
            if (lists.get(i) != null){
                priorityQueue.add(lists.get(i));
            }
        }

        ListNode dynamic = new ListNode(-1);
        ListNode cur = dynamic;
        while (!priorityQueue.isEmpty()){
            ListNode tmp = priorityQueue.poll();

            //拼接链表
            cur.next = tmp;
            cur = cur.next;

            if (tmp.next != null){
                priorityQueue.add(tmp.next);
            }
        }
        return dynamic.next;
    }



    public static void main(String[] args) {

    }
}
