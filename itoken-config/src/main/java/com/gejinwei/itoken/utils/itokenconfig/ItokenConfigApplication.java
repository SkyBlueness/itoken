package com.gejinwei.itoken.utils.itokenconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 分布式配置中心
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer   //开启配置中心
public class ItokenConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItokenConfigApplication.class, args);
    }
}
