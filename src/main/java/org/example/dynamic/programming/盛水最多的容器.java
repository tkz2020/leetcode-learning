package org.example.dynamic.programming;

public class 盛水最多的容器 {

    /**
     * BM93 盛水最多的容器
     * @param height
     * @return
     */
    public int maxArea (int[] height) {
        if (height == null && height.length == 0){
            return 0;
        }

        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right){
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

    }
}
