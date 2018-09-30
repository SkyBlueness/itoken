package com.gejinwei.itoken.utils.itokeneureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册和发布中心
 */
@SpringBootApplication
@EnableEurekaServer
public class ItokenEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItokenEurekaApplication.class, args);
    }
}
