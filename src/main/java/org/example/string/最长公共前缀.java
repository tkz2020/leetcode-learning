package org.example.string;

public class 最长公共前缀 {

    /**
     * BM84 最长公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix (String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }

        String s1 = strs[0];
        for (int i = 1; i < strs.length; i++){
            s1 = longestCommonPrefix(s1, strs[i]);
        }
        return s1;
    }


    public String longestCommonPrefix(String s1, String s2){
        int i = 0, len1 = s1.length() - 1;
        int j = 0, len2 = s2.length() - 1;
        while (i <= len1 || j <= len2){
            char c1 = i <= len1 ? s1.charAt(i) : ' ';
            char c2 = j <= len2 ? s2.charAt(j) : ' ';
            if (c1 != c2){
                break;
            }
            i++;
            j++;
        }
        return s1.substring(0, i);
    }


    public static void main(String[] args) {

    }

}
