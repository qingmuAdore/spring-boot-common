package com.pzhang.common.web;

/**
 * 应答工具类
 *
 * @author pzhang
 * @version v1.0.0
 * @date 2019/3/29
 */
public class ResponseUtil {

    public static AjaxResult ok() {
        return ok("success");
    }

    public static AjaxResult ok(String msg) {
        return ok(msg, null);
    }

    public static AjaxResult ok(String msg, Object data) {
        return sendResult(AjaxResult.CODE_SUCCESS, msg, data);
    }

    public static AjaxResult fail() {
        return fail("fail");
    }

    public static AjaxResult fail(String msg) {
        return fail(AjaxResult.CODE_FAIL, msg);
    }

    public static AjaxResult fail(int code, String msg) {
        return fail(code, msg, null);
    }

    public static AjaxResult fail(String msg, Object data) {
        return fail(AjaxResult.CODE_FAIL, msg, data);
    }

    public static AjaxResult fail(int code, String msg, Object data) {
        if (code == AjaxResult.CODE_SUCCESS) code = AjaxResult.CODE_FAIL;
        return sendResult(code, msg, data);
    }

    protected static AjaxResult sendResult(int code, String msg, Object data) {
        AjaxResult result = new AjaxResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}