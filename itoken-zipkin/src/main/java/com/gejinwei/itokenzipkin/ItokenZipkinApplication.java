package com.gejinwei.itokenzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
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
