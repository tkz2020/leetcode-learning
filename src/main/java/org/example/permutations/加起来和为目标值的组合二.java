package org.example.permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class 加起来和为目标值的组合二 {

    /**
     * NC46 加起来和为目标值的组合(二)
     * @param num
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if (num == null || num.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(num);
        int index = 0;
        Deque<Integer> path = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        dfs(num, target, index, path, resultList);
        return resultList;
    }


    public void dfs(int[] num, int target, int index, Deque<Integer> path, ArrayList<ArrayList<Integer>> resultList){
        if (target == 0){
            resultList.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < num.length; i++){
            if (num[i] > target){
                return;
            }

            //去除重复的元素
            if (i > index && num[i] == num[i-1]){
                continue;
            }

            path.addLast(num[i]);
            dfs(num, target - num[i], i + 1, path, resultList);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] nums = {100,10,20,70,60,10,50};
        int target = 80;
        加起来和为目标值的组合二 ss = new 加起来和为目标值的组合二();
        System.out.println(ss.combinationSum2(nums, target));
    }
}
