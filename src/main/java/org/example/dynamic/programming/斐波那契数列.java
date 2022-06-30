package org.example.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class 斐波那契数列 {


    Map<Integer, Integer> cache = new HashMap<>();
    public int fib(int n) {
        if (n == 1){
            cache.put(n, n);
            return n;
        }

        if (cache.get(n) != null){
            return cache.get(n) % 1000000007;
        }
        int tmp = fib(n-1) + fib(n-2);
        cache.put(n, tmp);
        return tmp % 1000000007;
    }


    public static void main(String[] args) {

    }
}
