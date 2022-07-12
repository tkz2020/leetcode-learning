package org.example.阻塞队列实现生产者消费者.BlockingQueue原生阻塞队列;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            Integer value = blockingQueue.take();
            System.out.println("===消费者获取到的元素为===" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
