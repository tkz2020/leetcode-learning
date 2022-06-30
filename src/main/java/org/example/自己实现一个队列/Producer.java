package org.example.自己实现一个队列;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable{

    private Queue queue = null;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        try {
            // 隔10秒轮询生产一次
            while (true) {
                System.out.println("Producer");
                TimeUnit.SECONDS.sleep(10);
                queue.put(new Random().nextInt(100),threadName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
