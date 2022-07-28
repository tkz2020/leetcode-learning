package org.example.string;

public class 验证回文字符串Ⅱ {

    /**
     * https://leetcode.cn/problems/valid-palindrome-ii/
     * 680. 验证回文字符串 Ⅱ
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }

        int left = 0, right = s.length() - 1;
        while (left <= right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            } else {
                return isPalindrom(s, left+1, right) || isPalindrom(s, left, right-1);
            }
        }
        return true;
    }


    public boolean isPalindrom(String s, int i, int j){
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
