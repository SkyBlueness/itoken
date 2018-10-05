package com.gejinwei.itoken.service.posts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.gejinwei.itoken.interceptor.mapper")
public class ItokenServicePostsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItokenServicePostsApplication.class, args);
    }
}
