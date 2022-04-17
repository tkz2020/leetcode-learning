package org.example.sliding.window;

public class 存在重复元素二 {

    /**
     * 219. 存在重复元素 II
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return false;
        }

        int left = 0;
        int right = 1;
        int len = nums.length;
        while (right < len){
            if (nums[right] != nums[left]){
                right++;
            } else {
                if (Math.abs(right - left) > k){
                    left++;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,1};
        int k = 1;
        存在重复元素二 ss = new 存在重复元素二();
        System.out.println(ss.containsNearbyDuplicate(nums, k));
    }
}
