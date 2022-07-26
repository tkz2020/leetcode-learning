package org.example.permutations;

import java.util.*;

public class 加起来和为目标值的组合四 {

    /**
     * https://www.nowcoder.com/practice/7a64b6a6cf2e4e88a0a73af0a967a82b?tpId=196&tqId=39467&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D5%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * NC233 加起来和为目标值的组合(四)
     * @param nums
     * @param target
     * @return
     */
    public int combination (int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(nums, target, 0, path, resultList);
        return resultList.size();
    }


    public void dfs(int[] nums, int target, int sum, Deque<Integer> path, List<List<Integer>> resultList){
        if (sum == target){
            resultList.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (sum + nums[i] > target){
                break;
            }

            sum += nums[i];
            path.addLast(nums[i]);
            dfs(nums, target, sum, path, resultList);
            sum -= nums[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        加起来和为目标值的组合四 ss = new 加起来和为目标值的组合四();
        System.out.println(ss.combination(nums, target));
    }
}
