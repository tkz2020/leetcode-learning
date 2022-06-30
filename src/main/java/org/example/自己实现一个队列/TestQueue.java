package org.example.自己实现一个队列;

public class TestQueue {


    public static void main(String[] args) {
        Queue queue = new Queue();
        Thread producer1 = new Thread(new Producer(queue));
        producer1.setName("Producer1");
        producer1.start();

        Thread producer2 = new Thread(new Producer(queue));
        producer2.setName("Producer2");
        producer2.start();

        Thread consumer = new Thread(new Consumer(queue));
        consumer.setName("Consumer");
        consumer.start();
    }

}
