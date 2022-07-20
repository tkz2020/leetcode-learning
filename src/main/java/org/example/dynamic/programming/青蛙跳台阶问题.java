package org.example.dynamic.programming;

public class 青蛙跳台阶问题 {

    /**
     * https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n == 0){
            return 1;
        }

        int a = 1, b = 1, sum = 0;
        for (int i = 0; i < n; i++){
            sum = (a+b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {

    }
}
