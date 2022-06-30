package org.example.设计模式;

public class 单例模式_饿汉式 {

    private static 单例模式_饿汉式 instance = new 单例模式_饿汉式();
    private 单例模式_饿汉式(){}

    public static 单例模式_饿汉式 getInstance(){
        return instance;
    }
}
