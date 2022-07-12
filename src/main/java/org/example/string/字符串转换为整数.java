package org.example.string;

public class 字符串转换为整数 {

    /**
     * https://leetcode.cn/problems/string-to-integer-atoi/
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        int len = s.length();
        char[] arrays = s.toCharArray();

        //1、去除前导的空格
        int index = 0;
        while (index < len && arrays[index] == ' '){
            index++;
        }

        //2、遍历完成，说明全是空格
        if (index == len){
            return 0;
        }

        //3、判断第一个有效的字符是否为正负号
        int flag = 1;
        char firstChar = arrays[index];
        if (firstChar == '+'){
            index++;
        } else if (firstChar == '-'){
            index++;
            flag = -1;
        }

        int result = 0;
        while (index < len){
            char c = arrays[index];
            if (c < '0' || c > '9'){
                break;
            }

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10)){
                return Integer.MAX_VALUE;
            }

            if (result < Integer.MIN_VALUE  / 10 || (result == Integer.MIN_VALUE  / 10 && (c - '0') > -(Integer.MIN_VALUE  % 10))){
                return Integer.MIN_VALUE;
            }

            result = result * 10 + flag * (c - '0');
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        字符串转换为整数 s = new 字符串转换为整数();
        String str = "2147483646";
        System.out.println(s.myAtoi(str));
    }
}
