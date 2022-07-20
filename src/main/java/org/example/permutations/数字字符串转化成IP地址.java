package org.example.permutations;

import java.util.ArrayList;

public class 数字字符串转化成IP地址 {

    /**
     * NC20 数字字符串转化成IP地址
     * @param s
     * @return
     */
    public ArrayList<String> restoreIpAddresses (String s) {
        ArrayList<String> res = new ArrayList<String>();
        dfs(s, res, 0, 0, "");
        return res;
    }


    /**
     *
     * @param s
     * @param resultList
     * @param step
     * @param index
     * @param nums
     */
    public void dfs(String s, ArrayList<String> resultList, int step, int index, String nums){
        String cur = "";
        if (step == 4){
            if (index != s.length()){
                return;
            }
            resultList.add(nums);
        }

        for (int i = index; i < index + 3 && i < s.length(); i++){
            cur += s.charAt(i);
            int num = Integer.parseInt(cur);
            String temp = nums;
            if (num <= 255 && (cur.length() == 1 || cur.charAt(0) != '0')){
                if (step - 3 != 0){
                    nums += cur + ".";
                } else {
                    nums += cur;
                }

                dfs(s, resultList, step + 1, i + 1, nums);

                nums = temp;
            }
        }
    }


    public static void main(String[] args) {
        String s = "25525522135";
        数字字符串转化成IP地址 ss = new 数字字符串转化成IP地址();
        ss.restoreIpAddresses(s);
    }
}
