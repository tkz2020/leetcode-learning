package org.example.设计模式;

public class 单例模式_懒汉式_线程安全 {


    private static 单例模式_懒汉式_线程安全 instance = null;

    private 单例模式_懒汉式_线程安全(){}

    public static synchronized 单例模式_懒汉式_线程安全 getInstance(){
        if (instance == null){
            instance = new 单例模式_懒汉式_线程安全();
        }
        return instance;
    }
}
