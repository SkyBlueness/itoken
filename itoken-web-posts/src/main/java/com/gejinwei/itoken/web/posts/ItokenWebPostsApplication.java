package com.gejinwei.itoken.web.posts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication(scanBasePackages = "com.gejinwei.itoken")
@EnableDiscoveryClient
@EnableFeignClients   //开启Feign服务
public class ItokenWebPostsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItokenWebPostsApplication.class, args);
    }
}
