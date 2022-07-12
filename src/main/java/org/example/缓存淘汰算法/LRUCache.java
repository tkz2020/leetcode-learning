package org.example.缓存淘汰算法;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /**
     * 定义双向链表
     */
    public class DoubleLinkedList {
        int key;
        int value;
        DoubleLinkedList prev;   //指向前一个节点
        DoubleLinkedList next;   //指向后一个节点
        DoubleLinkedList(){}
        DoubleLinkedList(int _key, int _value){
            this.key = _key;
            this.value = _value;
        }
    }


    private Map<Integer, DoubleLinkedList> cache = new HashMap<>();
    private int size;
    private int capacity;   //链表的长度
    private DoubleLinkedList head, tail;    //定义head 和 tail 指针，指向双向链表的头节点和尾节点

    /**
     * 初始化变量
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DoubleLinkedList();
        this.tail = new DoubleLinkedList();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedList node = cache.get(key);
        if (node == null){
            return -1;
        }

        //双向链表中删除当前 node 节点
        node.prev.next = node.next;
        node.next.prev = node.prev;

        //把当前 node 节点插入到链表的头部
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedList node = cache.get(key);
        if (node == null){
            DoubleLinkedList tmp = new DoubleLinkedList(key, value);
            cache.put(key, tmp);
            //把 tmp 节点插入到双向链表的头部
            appendHead(tmp);
            size++;
            if (size > capacity){
                //删除链表的尾部节点
                DoubleLinkedList temp = deleteTail();
                cache.remove(temp.key);
                --size;
            }
        } else {
            node.value = value;
            // 把当前 node 节点挪到双向链表的头部
            moveToHead(node);
        }
    }


    /**
     * 当前链表被访问到，把该链表放到链表的头部
     * @param node
     */
    public void moveToHead(DoubleLinkedList node){
        //双向链表中删除 node 节点
        node.prev.next = node.next;
        node.next.prev = node.prev;

        //把 node 节点插入到双向链表的头部
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }


    /**
     * 把当前节点放入到链表的头部
     * @param node
     */
    public void appendHead(DoubleLinkedList node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }


    /**
     * 删除链表的尾节点
     */
    public DoubleLinkedList deleteTail(){
        DoubleLinkedList node = tail.prev;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }
}
