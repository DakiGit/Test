package com.qf.utils;

/**
 * @Description:
 * @Company: **
 * @Author: Daki
 * @Date: 0016 6-16
 * @Time: 19:56
 */
public class R {
    private int code;
    private String msg;
    private Object data;

    public R(int code) {
        this.code = code;
    }

    public R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static R ok(){
        return new R(0);
    }
    public static R ok(String msg){
        return new R(0,msg);
    }
    public static R error(){
        return new R(1);
    }
    public static R error(String msg){
        return new R(1,msg);
    }
}
