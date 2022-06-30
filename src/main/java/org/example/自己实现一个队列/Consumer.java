package org.example.自己实现一个队列;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{

    private Queue queue = null;

    public Consumer(Queue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            // 隔3秒轮询消费一次
            while (true) {
                System.out.println("Customer");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("取到的值-" + queue.take());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
