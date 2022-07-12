package org.example.阻塞队列实现生产者消费者.wait和notify实现阻塞队列;

import java.util.Random;

public class Producer implements Runnable{

    private BlockingQueueSimple blockingQueueSimple;

    public Producer(BlockingQueueSimple blockingQueueSimple){
        this.blockingQueueSimple = blockingQueueSimple;
    }

    @Override
    public void run() {
        try {
            Object value = new Random().nextInt(100);
            blockingQueueSimple.put(value);
            System.out.println("====生产者生产的元素为====" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
