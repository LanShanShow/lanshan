package com.ls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: wangzhuang
 * @Date: 2019/1/30 16:08
 * @Description: 入口
 */
@SpringBootApplication(scanBasePackages = "com.ls")
public class ApiApplication {
    public static void main(String[] args){
        SpringApplication.run(ApiApplication.class,args);
    }
}
