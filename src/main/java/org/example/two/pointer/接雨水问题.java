package org.example.two.pointer;

public class 接雨水问题 {

    /**
     * BM94 接雨水问题
     * @param arr
     * @return
     */
    public long maxWater (int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }

        int left = 0, right = arr.length - 1;
        int maxLeft = 0, maxRight = 0;
        long result = 0;
        while (left < right){
            maxLeft = Math.max(maxLeft, arr[left]);
            maxRight = Math.max(maxRight, arr[right]);
            //右边大于左边，优先计算左边的
            if (maxRight > maxLeft){
                result += maxLeft - arr[left++];
            } else {
                result += maxRight - arr[right--];
            }
        }
        return result;
    }


    public int trap(int[] height){
        if (height == null || height.length == 0){
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, result = 0;
        while (left < right){
            if (height[left] < height[right]){
                if (height[left] > leftMax){
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax){
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                right--;
            }
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
