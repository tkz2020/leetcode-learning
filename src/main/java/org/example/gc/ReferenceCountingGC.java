package org.example.gc;

public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2* _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        //假设在这行发生gc，objA和ObjB是否能被回收
        System.gc();
    }
}
