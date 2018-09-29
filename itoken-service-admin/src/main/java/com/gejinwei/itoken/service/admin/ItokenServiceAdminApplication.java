package com.gejinwei.itoken.service.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.gejinwei.itoken.service.admin.mapper")
public class ItokenServiceAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItokenServiceAdminApplication.class, args);
    }
}
