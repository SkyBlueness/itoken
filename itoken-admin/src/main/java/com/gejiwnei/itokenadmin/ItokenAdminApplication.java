package com.gejiwnei.itokenadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 分布式服务监控
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
public class ItokenAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItokenAdminApplication.class, args);
    }
}
