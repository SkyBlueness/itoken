package com.gejinwei.itokeneureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册和发布中心
 */
@SpringBootApplication
@EnableEurekaServer
@EnableEurekaClient
public class ItokenEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItokenEurekaApplication.class, args);
    }
}
