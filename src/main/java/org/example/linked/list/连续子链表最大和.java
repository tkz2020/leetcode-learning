package org.example.linked.list;

import java.util.ArrayList;
import java.util.List;

public class 连续子链表最大和 {


    /**
     * NC295 连续子链表最大和
     * @param head
     * @return
     */
    public int FindGreatestSumOfSubArray (ListNode head) {
        if (head == null){
            return 0;
        }

        List<Integer> data = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            data.add(cur.val);
            cur = cur.next;
        }

        int[] nums = new int[data.size()];
        for (int i = 0; i < data.size(); i++){
            nums[i] = data.get(i);
        }

        //动态规划，求连续子数组的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    /**
     * NC295 连续子链表最大和
     * @param head
     * @return
     */
    public int FindGreatestSumOfSubArray1 (ListNode head){
        int ret = head.val, pre = 0;
        while (head != null){
            pre = Math.max(pre + head.val, head.val);
            ret = Math.max(ret, pre);
            head = head.next;
        }
        return ret;
    }


    public static void main(String[] args) {

    }
}
