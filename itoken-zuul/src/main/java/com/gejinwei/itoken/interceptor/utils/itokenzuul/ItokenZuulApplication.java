package com.gejinwei.itoken.interceptor.utils.itokenzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 路由网关
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ItokenZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItokenZuulApplication.class, args);
    }
}
