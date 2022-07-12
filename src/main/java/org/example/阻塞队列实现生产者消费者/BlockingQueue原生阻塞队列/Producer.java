package org.example.阻塞队列实现生产者消费者.BlockingQueue原生阻塞队列;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    private BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            int value = new Random().nextInt(100);
            blockingQueue.put(value);
            System.out.println("===生产者生产的元素为===" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
