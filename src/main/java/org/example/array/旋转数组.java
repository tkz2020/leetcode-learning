package org.example.array;

public class 旋转数组 {

    /**
     * BM97 旋转数组
     * @param n
     * @param m
     * @param a
     * @return
     */
    public int[] solve (int n, int m, int[] a) {
        m = m % n;
        //数组整体反转
        reverse(a, 0, n - 1);
        //先反转前m个元素
        reverse(a, 0, m-1);
        //在反转后n-m个元素
        reverse(a, m, n - 1);
        return a;
    }


    public void reverse(int[] nums, int left, int right){
        while (left < right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

    }
}
