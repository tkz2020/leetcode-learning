package org.example.test;

/**
 * 对于一个类而言，按照如下顺序执行：
 *   （1）执行静态代码块
 *   （2）执行构造代码块
 *   （3）执行构造函数
 *
 *  对于静态变量、静态初始化块、变量、初始化块、构造器，它们的初始化顺序依次是（静态变量、静态初始化块）>（变量、初始化块）>构造器。
 *
 *  运行以下代码，我们会得到如下的输出结果：
 *  1、静态变量
 *  2、静态初始化块
 *  3、变量
 *  4、初始化块
 *  5、构造器
 *
 */
public class HelloC {

    /**
     * 静态变量
     */
    public static String staticField = "静态变量";

    /**
     * 变量
     */
    public String field = "变量";

    /**
     * 静态代码块
     */
    static {
        System.out.println( staticField );
        System.out.println( "静态初始化块" );
    }

    {
        System.out.println( field );
        System.out.println( "初始化块" );
    }

    public HelloC(){
        System.out.println( "构造器" );
    }

    public static void main(String[] args) {
        HelloC helloC = new HelloC();
    }
}
