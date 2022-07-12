package org.example.阻塞队列实现生产者消费者.ReentrantLock和Condition实现阻塞队列;

import java.util.Random;

public class Producer implements Runnable{

    private BlockingQueueSimple blockingQueue;
    public Producer(BlockingQueueSimple blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            Object value = new Random().nextInt(100);
            blockingQueue.put(value);
            System.out.println("====生产者生产的元素为====" + value + ", 线程ID为===" + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
