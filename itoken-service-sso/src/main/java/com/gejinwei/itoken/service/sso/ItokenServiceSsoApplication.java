package com.gejinwei.itoken.service.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan(basePackages = "com.gejinwei.itoken.mapper")
public class ItokenServiceSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItokenServiceSsoApplication.class, args);
    }
}
