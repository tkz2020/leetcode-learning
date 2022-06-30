package org.example.thread;

public class ABC_Synch {


    public static class ThreadPrint implements Runnable{

        private String name;
        private Object prev;
        private Object self;

        private ThreadPrint(String name, Object prev, Object self){
            this.name = name;
            this.prev = prev;
            this.self = self;
        }


        @Override
        public void run() {
            int count = 10;
            while (count > 0){
                synchronized (prev){    //A -> prev=c,self=a   B -> prev=a,self=b   C -> prev=b,self=c
                    synchronized (self){
                        System.out.println(name);
                        count--;
                        self.notifyAll();   //唤醒其他线程竞争 self 锁，注意此时 self 锁并未释放
                    }

                    //此时执行完 self 的同步块，这时 self 锁才释放
                    try {
                        if (count == 0){
                            prev.notifyAll();
                        } else {
                            prev.wait();  // 立即释放 prev 锁，当前线程休眠，等待唤醒
                            /**
                             * JVM 会在wait() 对象锁的线程中随机选取一个线程，赋予其对象锁，唤醒线程，继续执行
                             */
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        ThreadPrint pa = new ThreadPrint("A", c, a);
        ThreadPrint pb = new ThreadPrint("B", a, b);
        ThreadPrint pc = new ThreadPrint("C", b, c);

        new Thread(pa).start();
        Thread.sleep(10);

        new Thread(pb).start();
        Thread.sleep(10);

        new Thread(pc).start();
        Thread.sleep(10);
    }
}
