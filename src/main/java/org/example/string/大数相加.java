package org.example.string;

public class 大数相加 {

    /**
     * 大数相加
     * @param s
     * @param t
     * @return
     */
    public String solve (String s, String t){
        if (s == null || t == null){
            return s == null ? t : s;
        }

        int len1 = s.length(), len2 = t.length();
        int i = len1 - 1, j = len2 - 1;
        int tmp = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0){
            int m = i >= 0 ? s.charAt(i--) - '0' : 0;
            int n = j >= 0 ? t.charAt(j--) - '0' : 0;
            tmp = m + n + tmp;
            result.append(tmp % 10);
            tmp /= 10;
        }

        if (tmp > 0){
            result.append(tmp);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "999999999999999999999999999";
        String t = "111111";
        大数相加 ss = new 大数相加();
        System.out.println(ss.solve(s, t));
    }
}
