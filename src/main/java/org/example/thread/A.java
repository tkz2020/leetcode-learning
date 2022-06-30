package org.example.thread;

import org.openjdk.jol.info.ClassLayout;

public class A {

    //占一个字节的 boolean 字段
    private boolean flag;

    public static void main(String[] args) {
        A a = new A();

        //打印对应的对象头信息
        System.out.println(ClassLayout.parseInstance(a).toPrintable());


        System.out.println("==========================================");


        A[] aa = new A[2];
        //打印对应的对象头信息
        System.out.println(ClassLayout.parseInstance(aa).toPrintable());

    }
}
