package org.example.线程间的五种通信方式;

import java.util.ArrayList;
import java.util.List;

public class TestVolatile {

    private static volatile boolean notice = false;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 10; i++){
                list.add("abc");
                System.out.println("线程A添加元素，此时list的size为：" + list.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() == 5){
                    notice = true;
                }
            }
        });


        Thread threadB = new Thread(() -> {
            while (true){
                if (notice){
                    System.out.println("线程B收到通知，开始执行自己的业务...");
                    break;
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
