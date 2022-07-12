package org.example.二分查找;

public class X的平方根 {


    /**
     * https://leetcode.cn/problems/sqrtx/
     * @param x
     * @return
     */
    public int mySqrt(int x){
        if (x < 2){
            return x;
        }

        int left = 1, right = x;
        while (left <= right){
            int middle = (left + right) >> 1;
            if (x / middle == middle){
                return  middle;
            } else if (x / middle < middle){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {

    }
}
