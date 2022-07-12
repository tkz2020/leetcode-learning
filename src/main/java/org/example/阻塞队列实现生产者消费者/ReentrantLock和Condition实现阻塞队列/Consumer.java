package org.example.阻塞队列实现生产者消费者.ReentrantLock和Condition实现阻塞队列;

public class Consumer implements Runnable{

    private BlockingQueueSimple blockingQueue;
    public Consumer(BlockingQueueSimple blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            Object value = blockingQueue.take();
            System.out.println("====阻塞队列获取的元素为====" + value + ", 线程ID为===" + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
