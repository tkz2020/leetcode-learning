package org.example.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 按序打印 {

    private int num;
    private Lock lock;
    private Condition condition1;
    private Condition condition2;
    private Condition condition3;

    public 按序打印(){
        num = 1;
        lock = new ReentrantLock();
        condition1 = lock.newCondition();
        condition2 = lock.newCondition();
        condition3 = lock.newCondition();
    }

    public void first(Runnable printFirst){
        lock.lock();
        try {
            while (num != 1){
                condition1.wait();
            }

            printFirst.run();
            num = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException{
        lock.lock();
        try {
            while (num != 2){
                condition2.wait();
            }

            printSecond.run();
            num = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void third(Runnable printThird) throws InterruptedException{
        lock.lock();
        try {
            while (num != 3){
                condition3.wait();
            }

            printThird.run();
            num = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
