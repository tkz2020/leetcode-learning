package org.example.practise;

public class 各位相加 {

    public int addDigits(int num) {
        if (num < 10){
            return num;
        }

        while (num >= 10){
            int sum = 0;
            while (num > 0){
                sum += num % 10;
                num = num / 10;
            }
            num = sum;
        }

        return num;
    }


    public static void main(String[] args) {
        int num = 38;
        各位相加 s = new 各位相加();
        s.addDigits(num);
    }

}
