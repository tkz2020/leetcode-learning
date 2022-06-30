package org.example.设计模式;

/**
 * 双重校验锁
 */
public class Singleton {


    /**
     * volatile 修饰
     * instance = new Singleton()可以拆分为三个步骤：
     * 1、分配对象内存(给singleton分配内存)
     * 2、调用构造器方法，执行初始化(调用Singleton的构造函数来初始化成员变量)
     * 3、将instance对象指向分配的内存空间(执行完这步instance就变成非null了)
     *
     * 但是JVM的即时编译器中存在指令重排序的优化。也就是说上面的2和3的顺序不能保证，最终的执行顺序
     * 可能是1->2->3，也有可能是1->3->2。如果是后者，则在3执行完毕之后，2未执行之前，被线程二抢占了，
     * 这时候instance已经是非null的了(但是却没有进行初始化)，所以线程二回直接返回instance，然后
     * 使用，然后顺理成章的报错了。
     *
     * volatile 禁止编译器的指令重排序
     */
    private volatile static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
