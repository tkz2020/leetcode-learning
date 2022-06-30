package org.example.设计模式;

/**
 * 非线程安全
 */
public class 单例模式_懒汉式_非线程安全 {

    private static 单例模式_懒汉式_非线程安全 instance = null;

    private 单例模式_懒汉式_非线程安全(){}

    public static 单例模式_懒汉式_非线程安全 getInstance(){
        if (instance == null){
            instance = new 单例模式_懒汉式_非线程安全();
        }
        return instance;
    }
}
