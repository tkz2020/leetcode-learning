package org.example.设计模式;

import java.lang.reflect.Proxy;

public class MyProxyTest {


    public static void main(String[] args) {
        IHello iHello = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(),  //加载接口的类加载器
                new Class[]{IHello.class},                                              //自定义接口
                new MyInvocationHandler(new IHelloImpl()));                             //自定义的InvocationHandler
        iHello.sayHello();
    }
}
