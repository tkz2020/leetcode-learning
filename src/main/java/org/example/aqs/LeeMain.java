package org.example.aqs;

public class LeeMain {


    static LeeLock leeLock = new LeeLock();
    static int count = 0;

    public static void main(String[] args) throws InterruptedException{
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    leeLock.lock();
                    for (int i = 0; i < 10000; i++){
                        count++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    leeLock.unlock();
                }
            }
        };


        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();

        System.out.println(count);
    }
}
