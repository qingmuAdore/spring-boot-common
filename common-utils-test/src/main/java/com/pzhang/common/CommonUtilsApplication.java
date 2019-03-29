package com.pzhang.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author pzhang
 * @version v1.0.0
 * @date 2019/3/29
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({"com.pzhang.common"})
public class CommonUtilsApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CommonUtilsApplication.class);
        application.run(args);
    }

}