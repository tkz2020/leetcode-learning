package org.example.test;

/**
 * https://www.cnblogs.com/Qian123/p/5713440.html
 * 1、静态代码块：
 * 静态代码块是随着类的加在而执行的，只执行一次，并优先于主函数。
 * 具体说，静态代码块是由类调用的。类调用时，先执行静态代码块，然后才执行主函数的。
 *
 * 2、构造代码块：
 * 构造代码块的作用是给对象进行初始化。
 * 对象一建立就运行构造代码块了，而且优先于构造函数执行。
 * 这里要强调一下，有对象建立，才会运行构造代码块，类不能调用构造代码块的，而且构造代码块与构造函数的执行顺序是前者先于后者执行。
 *
 * 3、构造函数：
 * 对象一建立，就会调用与之相应的构造函数，也就是说，不建立对象，构造函数时不会运行的。
 * 构造函数的作用是用于给对象进行初始化。
 * 一个对象建立，构造函数只运行一次，而一般方法可以被该对象调用多次。
 *
 *
  *
 */
public class HelloB extends HelloA{

    public HelloB(){
        System.out.println("B的构造方法");
    }

    {
        System.out.println("B的构造代码块");
    }

    static {
        System.out.println("B的静态代码块");
    }

    public static void main(String[] args) {
        HelloB helloB = new HelloB();
        System.out.println("B的main方法");
    }
}
