package org.example.two.pointer;

public class 最小覆盖子串 {

    /**
     * BM90 最小覆盖子串
     * @param S
     * @param T
     * @return
     */
    public String minWindow (String S, String T) {
        // write code here
        int[] need = new int[128];
        // 统计字符串T各个字符出现的次数
        char[] chart = T.toCharArray();
        for(char c : chart){
            need[c]++;
        }
        // 滑动窗口的左右边界
        int left = 0;
        int right = 0;
        // 滑动窗口的起始索引
        int start = 0;
        int count = T.length();
        // 滑动窗口的最小长度，当滑动窗口满足要求，更新最小长度
        int minSize = Integer.MAX_VALUE;
        char[] chars = S.toCharArray();
        while(right < chars.length){
            // 步骤一：移动滑动窗口的右边界，直到滑动窗口包含字符串T的所有字符
            char c = chars[right];
            if(need[c] > 0){
                count--;
            }
            need[c]--;
            // 步骤二：当滑动窗口中包含字符串T的所有字符，开始移动滑动窗口的左边界，直到滑动窗口缺失第一个字符串T的某一个字符（收缩滑动窗口）
            // 其实就是去除滑动窗口前端不需要的字符
            if(count == 0){
                char lChar = chars[left];
                while(need[lChar] < 0){
                    need[lChar]++;
                    left++;
                    lChar = chars[left];
                }
                // 步骤三：滑动窗口中包含了字符串T的所有字符，开始更新滑动窗口的最小长度以及起始索引
                if(right - left + 1 < minSize){
                    minSize = right - left + 1;
                    start = left;
                }
                // 滑动窗口向右移动，将left向右移动一位，循环比较后面满足要求的滑动窗口的最小长度
                need[lChar]++;
                left++;
                count++;
            }

            right++;
        }
        return minSize == Integer.MAX_VALUE ? "" : S.substring(start, start + minSize);
    }


    public static void main(String[] args) {
        String s = "XDOYEZODEYXNZ";
        String t = "XYZ";
        最小覆盖子串 ss = new 最小覆盖子串();
        System.out.println(ss.minWindow(s, t));
    }
}
