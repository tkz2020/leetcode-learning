package org.example.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC_Condition {

    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();

    private static int count = 0;

    static class ThreadA extends Thread{
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++){
                    while (count % 3 != 0){
                        A.wait();           //A释放锁
                    }
                    System.out.print("A");
                    count++;
                    B.signal();             //A执行完唤醒B线程
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


    static class ThreadB extends Thread{
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++){
                    while (count % 3 != 1){
                        B.wait();           //B释放锁
                    }
                    System.out.print("B");
                    count++;
                    C.signal();             //B执行完唤醒C线程
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


    static class ThreadC extends Thread{
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++){
                    while (count % 3 != 2){
                        C.wait();           //C释放锁
                    }
                    System.out.print("C");
                    count++;
                    A.signal();             //C执行完唤醒A线程
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }

}
