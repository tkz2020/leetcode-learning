package org.example.array;

import java.util.*;

public class 多个数组求交集 {

    /**
     * 2248. 多个数组求交集
     * 给你一个二维整数数组 nums ，其中 nums[i] 是由 不同 正整数组成的一个非空数组，按 升序排列 返回一个数组，数组中的每个元素在 nums 所有数组 中都出现过。
     *
     * 示例 1：
     * 输入：nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
     * 输出：[3,4]
     * 解释：nums[0] = [3,1,2,4,5]，nums[1] = [1,2,3,4]，nums[2] = [3,4,5,6]，在 nums 中每个数组中都出现的数字是 3 和 4 ，所以返回 [3,4] 。
     *
     * 示例 2：
     * 输入：nums = [[1,2,3],[4,5,6]]
     * 输出：[]
     * 解释：
     * 不存在同时出现在 nums[0] 和 nums[1] 的整数，所以返回一个空列表 [] 。
     * @param nums
     * @return
     */
    public List<Integer> intersection(int[][] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        Map<Integer, Integer> data = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++){
            int[] num = nums[i];
            for (int j = 0; j < num.length; j++){
                data.put(num[j], data.getOrDefault(num[j], 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> map : data.entrySet()){
            if (map.getValue() == len){
                result.add(map.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }

    /**
     * 求数组交集
     * @param nums
     * @return
     */
    public List<Integer> intersection1(int[][] nums){
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        int[] result = new int[1001];
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums[i].length; j++){
                result[nums[i][j]] += 1;
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < result.length; i++){
            if (result[i] == nums.length){
                resultList.add(i);
            }
        }
        Collections.sort(resultList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        return resultList;
    }


    public static void main(String[] args) {
        int[][] nums = {{3,1,2,4,5}, {1,2,3,4}, {3,4,5,6}};
        多个数组求交集 ss = new 多个数组求交集();
        List<Integer> result = ss.intersection1(nums);
        System.out.println(result);
    }
}
