package com.pyramidweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * spring boot启动文件
 * @author ydx
 * @date 2019-06-05
 * @version 1.0.0
 */
@SpringBootApplication
@ComponentScan(basePackages="com.pyramidweb")
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}
