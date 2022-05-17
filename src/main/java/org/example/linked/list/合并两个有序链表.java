package org.example.linked.list;

public class 合并两个有序链表 {


    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
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

    public static void main(String[] args) {

    }
}
