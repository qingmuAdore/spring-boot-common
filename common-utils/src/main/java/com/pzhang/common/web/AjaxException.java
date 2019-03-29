package com.pzhang.common.web;

/**
 * 定义ajax请求异常
 *
 * @author pzhang
 * @version v1.0.0
 * @date 2019/3/29
 */
public class AjaxException extends RuntimeException {
    private int code;
    private String msg;

    public AjaxException(int code, String msg) {
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
}