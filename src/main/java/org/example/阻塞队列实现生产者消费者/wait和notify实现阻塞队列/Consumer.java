package org.example.阻塞队列实现生产者消费者.wait和notify实现阻塞队列;

public class Consumer implements Runnable{

    private BlockingQueueSimple blockingQueue;

    public Consumer(BlockingQueueSimple blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            Object value = blockingQueue.take();
            System.out.println("====消费者获取到的元素为====" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
