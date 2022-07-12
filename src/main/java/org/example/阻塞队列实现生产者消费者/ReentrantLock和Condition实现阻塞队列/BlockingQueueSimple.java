package org.example.阻塞队列实现生产者消费者.ReentrantLock和Condition实现阻塞队列;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueSimple {

    private final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    private final Object[] queue;
    private int size;
    private int putIndex;
    private int takeIndex;

    public BlockingQueueSimple(int maxSize){
        queue = new Object[maxSize];
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    public void put(Object element) throws InterruptedException{
        lock.lock();
        try {
            while (size == queue.length){
                notFull.wait();
            }

            queue[putIndex] = element;
            if (++putIndex == queue.length)
                putIndex = 0;
            size++;

            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }


    public Object take () throws InterruptedException{
        lock.lock();
        try {
            while (size == 0){
                notEmpty.wait();
            }

            Object element =  queue[takeIndex];
            queue[takeIndex] = null;
            if (++takeIndex == queue.length)
                takeIndex = 0;
            size--;
            notFull.signal();
            return element;
        } finally {
            lock.unlock();
        }
    }
}
