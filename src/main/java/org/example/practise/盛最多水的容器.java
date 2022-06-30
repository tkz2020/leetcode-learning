package org.example.practise;

public class 盛最多水的容器 {

    /**
     * 11. 盛最多水的容器
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
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
