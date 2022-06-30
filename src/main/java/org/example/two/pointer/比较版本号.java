package org.example.two.pointer;

import java.util.Collections;

public class 比较版本号 {

    /**
     * 165. 比较版本号
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version1.length() == 0 || version2 == null || version2.length() == 0){
            return 0;
        }

        int i = 0, len1 = version1.length();
        int j = 0, len2 = version2.length();
        while (i < len1 || j < len2){
            int num1 = 0, num2 = 0;
            while (i < len1 && version1.charAt(i) != '.'){
                num1 = num1 * 10 + version1.charAt(i) - '0';
                i++;
            }

            while (j < len2 && version2.charAt(j) != '.'){
                num2 = num2 * 10 + version2.charAt(j) - '0';
                j++;
            }
            i++;
            j++;

            if (num1 > num2){
                return 1;
            } else if (num1 < num2){
                return -1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {

    }
}
