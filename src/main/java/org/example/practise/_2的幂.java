package org.example.practise;

public class _2的幂 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }

    public static void main(String[] args) {

    }
}
