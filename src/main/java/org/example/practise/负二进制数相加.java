package org.example.practise;

import java.util.Arrays;

public class 负二进制数相加 {

    /**
     * 1073. 负二进制数相加
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null){
            return arr1 == null ? arr2 : arr1;
        }

        StringBuilder result = new StringBuilder();
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int tmp = 0;
        while (i >= 0 || j >= 0){
            int a = i >= 0 ? arr1[i] : 0;
            int b = j >= 0 ? arr2[j] : 0;
            int sum = a + b + tmp;
            result.append(sum > 1 ? 0 : sum);
            tmp = sum > 1 ? 1 : 0;
            i--;
            j--;
        }

        if (tmp > 0){
            result.append(tmp);
        }

        int[] res = new int[result.toString().length()];
        String[] str = result.toString().split(",");
        int index = 0;
        for (int t = str.length - 1; t >= 0; t--){
            res[index++] = Integer.parseInt(str[t]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,1,1,1,1};
        int[] arr2 = new int[]{1,0,1};
        负二进制数相加 ss = new 负二进制数相加();
        ss.addNegabinary(arr1, arr2);
    }
}
