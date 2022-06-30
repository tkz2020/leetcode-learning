package org.example.设计模式;

public class 单例模式_静态内部类 {

    private static class SingletonHolder{
        private static final 单例模式_静态内部类 INSTANCE = new 单例模式_静态内部类();
    }

    private 单例模式_静态内部类(){}

    public static 单例模式_静态内部类 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
