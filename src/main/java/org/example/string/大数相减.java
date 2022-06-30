package org.example.string;

public class 大数相减 {


    public String sub(String m, String n){
        if (m.length() == 0 || n.length() == 0){
            return m.length() == 0 ? n : m;
        }

        int i = m.length() - 1;
        int j = n.length() - 1;
        int borrow = 0;
        StringBuilder result = new StringBuilder("");
        while (i >= 0 || j >= 0){
            int a = i >= 0 ? m.charAt(i--) - '0' : 0;
            int b = j >= 0 ? n.charAt(j--) - '0' : 0;
            int tmp = (a - borrow -b + 10) % 10;
            result.append(tmp);
            borrow = a - borrow - b < 0 ? 1 : 0;
        }
        String res = result.reverse().toString();

        int pos;
        for (pos = 0; pos < res.length() - 1; pos++){
            if (res.charAt(pos) != '0'){
                break;
            }
        }

        return res.substring(pos);
    }


    /**
     * 字符串相减  条件是m的长度要大于n
     * @param m
     * @param n
     * @return
     */
    public String subtraction(String m, String n){
        if (m.length() > n.length()){
            return sub(m, n);
        }
        return sub(n, m);
    }

    public static void main(String[] args) {
        String a = "210";
        String b = "9";
        大数相减 ss = new 大数相减();
        System.out.println(ss.subtraction(a, b));
    }
}
