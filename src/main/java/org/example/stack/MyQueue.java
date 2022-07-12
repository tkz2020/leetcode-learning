package org.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用两个栈实现一个队列
 */
public class MyQueue {

    private Deque<Integer> deque1;
    private Deque<Integer> deque2;

    public MyQueue() {
        deque1 = new ArrayDeque<>();
        deque2 = new ArrayDeque<>();
    }

    public void push(int x) {
        deque1.push(x);
    }

    public int pop() {
        if (deque2.isEmpty()){
            while (!deque1.isEmpty()){
                deque2.push(deque1.pop());
            }
        }

        if (!deque2.isEmpty()){
            return deque2.pop();
        }
        return -1;
    }

    public int peek() {
        if (deque2.isEmpty()){
            while (!deque1.isEmpty()){
                deque2.push(deque1.pop());
            }
        }

        if (!deque2.isEmpty()){
            return deque2.peek();
        }
        return -1;
    }

    public boolean empty() {
        return deque1.isEmpty() && deque2.isEmpty();
    }

}
