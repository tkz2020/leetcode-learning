package org.example.array;

public class 比特位计数 {

    public int[] countBits(int n) {

        int[] nums = new int[n+1];
        for (int i = 0; i <= n; i++){
            String binaryString = binaryConvert(i, 2);
            nums[i] = binaryCount(binaryString);
        }
        return nums;
    }


    public int binaryCount(String binaryString){
        int binaryCount = 0;
        char[] chars = binaryString.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == '1'){
                binaryCount++;
            }
        }
        return binaryCount;
    }


    /**
     * 进制转换
     * @param target
     * @param base
     * @return
     */
    public String binaryConvert(int target, int base){
        StringBuilder result = new StringBuilder();
        while (target != 0) {
            result.append(target % base);
            target /= base;
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(10));
        int target = 10;
        int base = 2;
        比特位计数 ss = new 比特位计数();
        System.out.println(ss.binaryConvert(target, base));
    }
}
