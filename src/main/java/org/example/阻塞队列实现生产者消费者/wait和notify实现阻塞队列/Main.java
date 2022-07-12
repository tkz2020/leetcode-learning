package org.example.阻塞队列实现生产者消费者.wait和notify实现阻塞队列;

public class Main {

    public static void main(String[] args) {
        int maxSize = 10;
        BlockingQueueSimple blockingQueueSimple = new BlockingQueueSimple(maxSize);

        Thread producer1 = new Thread(new Producer(blockingQueueSimple));
        Thread producer2 = new Thread(new Producer(blockingQueueSimple));
        Thread producer3 = new Thread(new Producer(blockingQueueSimple));
        Thread producer4 = new Thread(new Producer(blockingQueueSimple));
        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();

        Thread consumer1 = new Thread(new Consumer(blockingQueueSimple));
        Thread consumer2 = new Thread(new Consumer(blockingQueueSimple));
        Thread consumer3 = new Thread(new Consumer(blockingQueueSimple));
        Thread consumer4 = new Thread(new Consumer(blockingQueueSimple));
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
    }
}
