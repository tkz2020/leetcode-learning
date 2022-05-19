package org.example.binary.search;

public class X的平方根 {


    /**
     * x 的平方根
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x < 2){
            return x;
        }

        int left = 1, right = x;
        while (left <= right){
            int middle = left + (right - left) / 2;
            if (x / middle == middle){
                return middle;
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
