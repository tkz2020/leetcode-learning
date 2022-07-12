package org.example.dynamic.programming.背包系列;

public class 分割等和子集 {

        /**
         * https://leetcode.cn/problems/partition-equal-subset-sum/
         * 转换为 0-1 背包，背包的容量为 target = sum/2，每个数组元素的 [价值] 与 [成本] 都是其数值大小，求我们能否装满背包
         * @param nums
         * @return
         */
        public boolean canPartition(int[] nums) {
                if (nums == null || nums.length == 0){
                        return false;
                }

                int len = nums.length;
                int sum = 0;
                for (int num : nums){
                        sum += num;
                }

                //计算背包的容量
                int target = sum / 2;
                if (target * 2 != sum){
                        return false;
                }

                // len 表示物品的个数，target 表示背包的容量，target + 1 表示背包的容量从 0 开始考虑
                int[][] f = new int[len][target+1];
                for (int j = 0; j <= target; j++){
                        f[0][j] = j >= nums[0] ? nums[0] : 0;
                }


                for (int i = 1; i < len; i++){
                        // t 表示第 i 件物品的容量
                        int t = nums[i];
                        for (int j = 0; j <= target; j++){
                                //不选择第 i 件物品
                                int no = f[i-1][j];

                                //选择第 i 件物品
                                int yes = j >= t ? f[i-1][j-t] + t : 0;
                                f[i][j] = Math.max(no, yes);
                        }
                }

                return f[len-1][target] == target;
        }

        public static void main(String[] args) {

        }
}
