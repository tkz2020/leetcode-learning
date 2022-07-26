package org.example.permutations;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class 加起来和为目标值的组合 {

    /**
     * https://www.nowcoder.com/practice/172e6420abf84c11840ed6b36a48f8cd?tpId=196&tqId=39480&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%25E5%258A%25A0%25E8%25B5%25B7%25E6%259D%25A5%25E5%2592%258C%25E4%25B8%25BA%25E7%259B%25AE%25E6%25A0%2587%25E5%2580%25BC%25E7%259A%2584%25E7%25BB%2584%25E5%2590%2588%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=%E5%8A%A0%E8%B5%B7%E6%9D%A5%E5%92%8C%E4%B8%BA%E7%9B%AE%E6%A0%87%E5%80%BC%E7%9A%84%E7%BB%84%E5%90%88
     * NC238 加起来和为目标值的组合
     * @param target
     * @param nums
     * @return
     */
    public ArrayList<ArrayList<Integer>> combinationCount (int target, int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        dfs(nums, target, 0, 0, path, resultList);
        return resultList;
    }


    public void dfs(int[] nums, int target, int startIndex, int sum, Deque<Integer> path, ArrayList<ArrayList<Integer>> resultList){
        if (sum == target){
            resultList.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < nums.length; i++){
            if (sum + nums[i] > target){
                break;
            }

            sum += nums[i];
            path.addLast(nums[i]);
            dfs(nums, target, i, sum, path, resultList);
            sum -= nums[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,4,5};
        int target = 5;
        加起来和为目标值的组合 ss = new 加起来和为目标值的组合();
        System.out.println(ss.combinationCount(target, nums));
    }
}
