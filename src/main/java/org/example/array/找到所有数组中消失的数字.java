package org.example.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 找到所有数组中消失的数字 {



    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        Set<Integer> set1 = new HashSet<>();
        for (int i = 1; i <= len; i++){
            set1.add(i);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int j = 0; j < nums.length; j++){
            set2.add(nums[j]);
        }
        set1.removeAll(set2);
        return new ArrayList<>(set1);
    }


    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        找到所有数组中消失的数字 ss = new 找到所有数组中消失的数字();
        System.out.println(ss.findDisappearedNumbers(nums));
    }
}
