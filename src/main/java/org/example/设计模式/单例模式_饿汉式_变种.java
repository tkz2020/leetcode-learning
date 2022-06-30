package org.example.设计模式;

public class 单例模式_饿汉式_变种 {

    private static 单例模式_饿汉式_变种 instance = null;
    static {
        instance = new 单例模式_饿汉式_变种();
    }
    private 单例模式_饿汉式_变种(){}

    public static 单例模式_饿汉式_变种 getInstance(){
        return instance;
    }
}
