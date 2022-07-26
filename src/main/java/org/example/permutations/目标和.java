package org.example.permutations;

public class 目标和 {

    /**
     * https://leetcode.cn/problems/target-sum/
     * @param nums
     * @param target
     * @return
     */
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int sum = 0, index = 0;
        dfs(nums, target, index, sum);
        return count;
    }


    public void dfs(int[] nums, int target, int index, int sum){
        if (index == nums.length){
            if (sum == target){
                count++;
            }
        } else {
            dfs(nums, target, index+1, sum + nums[index]);
            dfs(nums, target, index+1, sum - nums[index]);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        目标和 ss = new 目标和();
        System.out.println(ss.findTargetSumWays(nums, target));
    }
}
