package com.pzhang.common.controller;

import com.alibaba.fastjson.JSON;
import com.pzhang.common.web.AjaxResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author pzhang
 * @version v1.0.0
 * @date 2019/3/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AjaxExceptionControllerTest {

    @Autowired
    private WebApplicationContext context;

    //mock api 模拟http请求
    private MockMvc mockMvc;

    //初始化工作
    @Before
    public void setUp() {
        //独立安装测试
//        mockMvc = MockMvcBuilders.standaloneSetup(new AjaxExceptionController()).build();
        //集成Web环境测试（此种方式并不会集成真正的web环境，而是通过相应的Mock API进行模拟测试，无须启动服务器）
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    //测试
    @Test
    public void error() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/ajax/exception/error")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        AjaxResult result = JSON.parseObject(content, AjaxResult.class);
        Assert.assertTrue("code", result.getCode() == AjaxResult.CODE_FAIL);
    }


    @Test
    public void ajaxError() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/ajax/exception/ajax_error")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        AjaxResult result = JSON.parseObject(content, AjaxResult.class);
        Assert.assertTrue("code", result.getCode() == 101);
    }

}