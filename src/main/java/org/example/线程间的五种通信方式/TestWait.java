package org.example.线程间的五种通信方式;

import java.util.ArrayList;
import java.util.List;

public class TestWait {

    public static void main(String[] args) {
        Object object = new Object();
        List<String> list = new ArrayList<>();
        Thread threadA = new Thread(() -> {
            synchronized (object){
                for (int i = 1; i <= 10; i++){
                    list.add("abc");
                    System.out.println("线程A添加元素，此时list的size为：" + list.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (list.size() == 5){
                        object.notify();  // notify 是不释放锁的
                    }
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while (true){
                synchronized (object){
                    if (list.size() != 5){
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("线程B收到通知，开始执行自己的业务...");
                }
            }
        });

        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.start();
    }
}
