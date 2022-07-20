package org.example.test;

/**
 * https://www.cnblogs.com/Qian123/p/5713440.html
 * 当涉及到继承时，按照如下顺序执行：
 * 1、执行父类的静态代码块，并初始化父类静态成员变量
 * 2、执行子类的静态代码块，并初始化子类静态成员变量
 * 3、执行父类的构造代码块，执行父类的构造函数，并初始化父类普通成员变量
 * 4、执行子类的构造代码块， 执行子类的构造函数，并初始化子类普通成员变量
 */
public class SubClass extends Parent{

    /**
     * 静态变量
     */
    public static String s_StaticField = "子类--静态变量";

    /**
     * 变量
     */
    public String s_Field = "子类--变量";

    /**
     * 静态代码块
     */
    static {
        System.out.println( s_StaticField );
        System.out.println( "子类--静态初始化块" );
    }

    /**
     * 构造代码块
     */
    {
        System.out.println( s_Field );
        System.out.println( "子类--初始化块" );
    }


    /**
     * 构造方法
     */
    public SubClass(){
        System.out.println( "子类--构造器" );
        System.out.println( "i=" + i + ",j=" + j );
    }

    public static void main(String[] args) {
        System.out.println( "子类main方法" );
        SubClass subClass = new SubClass();
    }
}
