package com.pzhang.common.controller;

import com.pzhang.common.web.AjaxException;
import com.pzhang.common.web.AjaxResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author pzhang
 * @version v1.0.0
 * @date 2019/3/29
 */
@RestController
@RequestMapping("/ajax/exception")
public class AjaxExceptionController {

    @RequestMapping(method = RequestMethod.GET, value = "/error")
    public AjaxResult triggerException() throws Exception {
        throw new Exception("trigger exception");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ajax_error")
    public AjaxResult riggerAjaxException() {
        throw new AjaxException(101, "trigger ajax exception");
    }

}