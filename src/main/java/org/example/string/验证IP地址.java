package org.example.string;

import java.util.Arrays;

public class 验证IP地址 {


    /**
     * 468. 验证IP地址
     * @param queryIP
     * @return
     */
    public String validIPAddress(String queryIP) {
        if (queryIP == null && queryIP.length() == 0){
            return "Neither";
        }

        if (queryIP.contains(".")){
            return checkIPv4(queryIP) ? "IPv4" : "Neither";
        }

        if (queryIP.contains(":")){
            return checkIPv6(queryIP) ? "IPv6" : "Neither";
        }
        return "Neither";
    }


    public boolean checkIPv4(String str){
        String[] res = str.split("\\.", -1);
        if (res == null || res.length == 0 || res.length != 4){
            return false;
        }

        for (int i = 0; i < res.length; i++){
            if (res[i] == null || res[i].length() == 0 || (res[i].charAt(0) == '0' && res[i].length() > 1)){
                return false;
            }

            for (int j = 0; j < res[i].length(); j++){
                if (res[i].charAt(j) < '0' || res[i].charAt(j) > '9'){
                    return false;
                }
            }

            if (res[i].length() > 3 || Integer.parseInt(res[i]) > 255){
                return false;
            }
        }
        return true;
    }


    public boolean checkIPv6(String str){
        String[] res = str.split(":", -1);
        if (res == null || res.length != 8){
            return false;
        }

        for (int i = 0; i < res.length; i++){
            if (res[i] == null || res[i].length() == 0 || res[i].length() > 4){
                return false;
            }

            for (int j = 0; j < res[i].length(); j++){
                char c = res[i].charAt(j);
                //这块需要注意是从A到F  a到f
                if ((c < '0' || c > '9') && (c < 'a' || c > 'f') && (c < 'A' || c > 'F')){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "192.0.0.1";
        验证IP地址 ss = new 验证IP地址();
        System.out.println(ss.validIPAddress(s));
    }
}
