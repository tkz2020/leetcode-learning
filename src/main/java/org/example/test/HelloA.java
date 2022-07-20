package org.example.test;

public class HelloA {

    public HelloA(){
        System.out.println("A的构造函数");
    }

    {
        System.out.println("A的构造代码块");
    }

    static {
        System.out.println("A的静态代码块");
    }

    public static void main(String[] args) {
        HelloA helloA = new HelloA();
        System.out.println("A的main方法");
    }
}
