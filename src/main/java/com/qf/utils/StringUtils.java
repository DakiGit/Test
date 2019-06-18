package com.qf.utils;

/**
 * @Description:
 * @Company: **
 * @Author: Daki
 * @Date: 0016 6-16
 * @Time: 23:20
 */
public class StringUtils {

    public static boolean isEmpty(String key){
        if(key==null){
            return true;
        }
        key = key.trim();
        if("".equals(key)){
            return true;
        }
        return false;
    }

    public  static  boolean isNotEmpty(String key){
        return  !isEmpty(key);
    }

}
