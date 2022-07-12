package org.example.阻塞队列实现生产者消费者.wait和notify实现阻塞队列;

/**
 * wait 和 notifyAll 实现阻塞队列
 */
public class BlockingQueueSimple {

    private Object[] queue;
    public int size;

    private int head = 0;
    private int tail = 0;

    public BlockingQueueSimple(int maxSize){
        this.queue = new Object[maxSize];
    }

    public synchronized void put(Object element) throws InterruptedException{
        while (size == queue.length){
            wait();
        }

        size++;
        queue[tail] = element;
        if (tail == queue.length - 1){
            tail = 0;
        } else {
            tail++;
        }

        if (size == 1){
            notifyAll();
        }
    }

    public synchronized Object take() throws InterruptedException{
        while (size == 0){
            wait();
        }

        size--;
        Object element = queue[head];
        queue[head] = null;
        if (head == queue.length - 1){
            head = 0;
        } else {
            head++;
        }

        if (size == queue.length - 1){
            notifyAll();
        }
        return element;
    }
}
