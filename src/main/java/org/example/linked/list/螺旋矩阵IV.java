package org.example.linked.list;

import java.util.Arrays;

public class 螺旋矩阵IV {

    /**
     * https://leetcode.cn/problems/spiral-matrix-iv/
     * @param m
     * @param n
     * @param head
     * @return
     */
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        //优先填充-1
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                result[i][j] = -1;
            }
        }

        int left = 0, right = n-1;
        int top = 0, bottom = m-1;
        ListNode tmp = head;
        while (left <= right && top <= bottom){
            for (int i = left; i <= right && tmp != null; i++){
                result[top][i] = tmp.val;
                tmp = tmp.next;
            }

            for (int j = top+1; j <= bottom && tmp != null; j++){
                result[j][right] = tmp.val;
                tmp = tmp.next;
            }

            if (left < right && top < bottom){
                for (int i = right - 1; i > left && tmp != null; i--){
                    result[bottom][i] = tmp.val;
                    tmp = tmp.next;
                }

                for (int j = bottom; j > top && tmp != null; j--){
                    result[j][left] = tmp.val;
                    tmp = tmp.next;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(6);
        ListNode l5 = new ListNode(8);
        ListNode l6 = new ListNode(1);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(4);
        ListNode l10 = new ListNode(2);
        ListNode l11 = new ListNode(5);
        ListNode l12 = new ListNode(5);
        ListNode l13 = new ListNode(0);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        l10.next = l11;
        l11.next = l12;
        l12.next = l13;

        int m = 3, n = 5;
        螺旋矩阵IV ss = new 螺旋矩阵IV();
        int[][] result = ss.spiralMatrix(m, n, l1);
        for (int i = 0; i < result.length; i++){
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
