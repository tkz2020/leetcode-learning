package org.example.hash;

import java.util.Comparator;
import java.util.Map;

public class CustomComparator implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        if (o1.getValue().equals(o2.getValue())){
            return o2.getKey().compareTo(o1.getKey());
        } else {
            return o1.getValue() - o2.getValue();
        }
    }
}
