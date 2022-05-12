package org.example.bigdata.add;

public class 字符串相加 {


    /**
     * 415. 字符串相加
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0){
            return num2;
        }

        if (num2 == null || num2.length() == 0){
            return num1;
        }

        StringBuffer result = new StringBuffer();
        int i = num1.length() - 1;
        int j = num2.length() - 2;
        int tmp = 0;
        while (i >= 0 || j >= 0){
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            tmp = a + b + tmp;
            result.append(tmp % 10);
            tmp = tmp / 10;
            i--;
            j--;
        }

        if (tmp > 0){
            result.append(tmp);
        }

        return result.reverse().toString();
    }


    public static void main(String[] args) {

    }
}
