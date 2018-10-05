package com.gejinwei.itoken.interceptor.utils.itokenzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;

/**
 * 分布式跟踪链路
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ItokenZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItokenZipkinApplication.class, args);
    }
}
