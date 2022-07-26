package org.example.二分查找;

public class 在旋转过的有序数组中寻找目标值 {

    /**
     * https://www.nowcoder.com/practice/87c0e7abcbda41e7963660fa7d020995?tpId=196&tqId=37078&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * NC48 在旋转过的有序数组中寻找目标值
     * @param nums
     * @param target
     * @return
     */
    public int search (int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right){
            int middle = left + (right - left) / 2;
            if (nums[middle] == target){
                return middle;
            } else if (nums[left] <= nums[middle]){
                if (nums[left] <= target && nums[middle] > target){
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (nums[middle] < target && nums[right] >= target){
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {6,8,10,0,2,4};
        int target = 3;
        在旋转过的有序数组中寻找目标值 ss = new 在旋转过的有序数组中寻找目标值();
        System.out.println(ss.search(nums, target));
    }
}
