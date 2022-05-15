package org.example.linked.list;

public class PrintListNode {

    /**
     * 打印链表
     * @param listNode
     */
    public static void printListNode(ListNode listNode){
        StringBuilder result = new StringBuilder();
        while (listNode != null){
            if (result.length() > 0){
                result.append(listNode.val);
            }
            result.append("--->");
            listNode = listNode.next;
        }
        System.out.println("=====print ListNode====" + result);
    }
}
