package org.example.stack;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class 用两个队列实现栈 {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    /**
     * 向栈中存入数据
     * @param x
     */
    public void push(Integer x){
        queue2.offer(x);
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    /**
     * 取出栈顶的元素
     * @return
     */
    public Integer pop(){
        return queue1.poll();
    }


    public int top(){
        return queue1.peek();
    }


    public boolean empty(){
        return queue1.isEmpty();
    }

    public static void main(String[] args) {

    }
}
