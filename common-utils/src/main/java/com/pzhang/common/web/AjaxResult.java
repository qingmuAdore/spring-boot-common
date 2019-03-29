package com.pzhang.common.web;

/**
 * @author pzhang
 * @version v1.0.0
 * @date 2019/3/29
 */
public class AjaxResult {

    /**
     * 默认编码
     */
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_FAIL = 1;


    private int code;
    private String msg;
    private Object data;

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
}