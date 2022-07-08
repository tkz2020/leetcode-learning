package org.example.two.pointer;

public class 有效的回文串 {


    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }

        StringBuilder sb = new StringBuilder();
        int left = 0, len = s.length();
        while (left < len){
            char c = s.charAt(left++);
            if (Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }

            if (Character.isDigit(c)){
                sb.append(c);
            }
        }

        int i = 0, j = sb.length() - 1;
        while (i < j){
            if (sb.charAt(i) != sb.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        有效的回文串 ss = new 有效的回文串();
        ss.isPalindrome(s);
    }
}
