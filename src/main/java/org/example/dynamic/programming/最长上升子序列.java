package org.example.dynamic.programming;

public class 最长上升子序列 {

    /**
     * BM71 最长上升子序列(一)
     * https://www.nowcoder.com/practice/5164f38b67f846fb8699e9352695cd2f?tpId=196&tqId=39286&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%25E6%259C%2580%25E9%2595%25BF%25E4%25B8%258A%25E5%258D%2587%25E5%25AD%2590%25E5%25BA%258F%25E5%2588%2597%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=%E6%9C%80%E9%95%BF%E4%B8%8A%E5%8D%87%E5%AD%90%E5%BA%8F%E5%88%97
     * @param arr
     * @return
     */
    public int LIS (int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }

        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++){
            dp[i] = 1;
        }

        /**
         * 后一位的和前一位的相互比较，需要大于前一位的
         */
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < i; j++){
                if (arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = dp[0];
        for (int i = 0; i < dp.length; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
