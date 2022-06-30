package org.example.设计模式;

public class 单例模式_双重检索 {

    private volatile static 单例模式_双重检索 instance;

    private 单例模式_双重检索(){}

    /**
     * volatile 修饰，
     * singleton = new Singleton() 可以拆解为3步：
     * 1、分配对象内存(给singleton分配内存)
     * 2、调用构造器方法，执行初始化（调用 Singleton 的构造函数来初始化成员变量）。
     * 3、将对象引用赋值给变量(执行完这步 singleton 就为非 null 了)。
     * 若发生重排序，假设 A 线程执行了 1 和 3 ，还没有执行 2，B 线程来到判断 NULL，B 线程就会直接返回还没初始化的 instance 了。
     * volatile 可以避免重排序。
     * @return
     */
    public static 单例模式_双重检索 getInstance(){
        if (instance == null){
            synchronized(单例模式_双重检索.class){
                if (instance == null){
                    instance = new 单例模式_双重检索();
                }
            }
        }
        return instance;
    }
}
