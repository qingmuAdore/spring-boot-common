package com.pzhang.common.web;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * @author pzhang
 * @version v1.0.0
 * @date 2019/3/29
 */
@RestControllerAdvice
public class AjaxExceptionHandler {

    @ExceptionHandler(Exception.class)
    public AjaxResult handle(Exception ex) {
        ex.printStackTrace();
        return ResponseUtil.fail(ex.getMessage());
    }

    @ExceptionHandler(AjaxException.class)
    public AjaxResult handle(AjaxException ex) {
        ex.printStackTrace();
        return ResponseUtil.fail(ex.getCode(), ex.getMsg());
    }

}