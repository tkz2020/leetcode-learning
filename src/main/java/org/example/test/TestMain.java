package org.example.test;

import java.util.HashMap;
import java.util.Map;

public class TestMain {

    public static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        System.out.println(MAXIMUM_CAPACITY);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
    }
}
