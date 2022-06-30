package org.example.自己实现一个队列;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Queue {

    private int[] objects = new int[5];
    int size = 0;

    private Lock lock = new ReentrantLock();
    public Condition putCondition = lock.newCondition();
    public Condition takeCondition = lock.newCondition();

    public void lock() {
        lock.lock();
    }

    public void unLock() {
        lock.unlock();
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==5;
    }

    public void put(Integer value,String name) throws Exception{
        try {
            lock.lock();
            if (isFull()){
                // 队列满了让生产者等待
                putCondition.await();
            }
            objects[size % 5] = value;
            size++;
            // 生产完唤醒消费者
            takeCondition.signalAll();
        } finally {
            System.out.println(name +"-put-" + Arrays.toString(objects));
            lock.unlock();
        }
    }


    public int take() throws Exception {
        try {
            lock.lock();
            // 队列空了就让生产者等待
            if (isEmpty()){
                takeCondition.await();
            }
            int value = objects[size % 5];
            size--;
            // 消费完通知生产者
            putCondition.signalAll();
            return value;
        } finally {
            System.out.println("take-" + Arrays.toString(objects));
            lock.unlock();
        }
    }
}
