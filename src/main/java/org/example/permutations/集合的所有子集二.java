package org.example.permutations;

import java.util.*;

public class 集合的所有子集二 {

    /**
     * https://www.nowcoder.com/practice/a3dfd4bc8ae74fad9bc65d5ced7ae813?tpId=196&tqId=39444&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=591&title=
     * NC221 集合的所有子集(二)
     * @param nums
     * @return
     */
    public ArrayList<ArrayList<Integer>> subsets (int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        Set<ArrayList<Integer>> resultSet = new HashSet<>();
        dfs(nums, nums.length, 0, path, resultSet);
        return new ArrayList<>(resultSet);
    }


    public void dfs(int[] nums, int len, int startIndex, Deque<Integer> path, Set<ArrayList<Integer>> resultSet){
        resultSet.add(new ArrayList<>(path));
        if (startIndex == len){
            return;
        }

        for (int i = startIndex; i < len; i++){
            path.addLast(nums[i]);
            dfs(nums, len, i+1, path, resultSet);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,6,7,5};
        集合的所有子集二 ss = new 集合的所有子集二();
        System.out.println(ss.subsets(nums));
    }
}
