package com.gejinwei.itoken.service.posts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@EnableSwagger2    //开启Swagger2服务
@SpringBootApplication(scanBasePackages = "com.gejinwei.itoken")
@EnableEurekaClient
@MapperScan("com.gejinwei.itoken.service.posts.mapper")
public class ItokenServicePostsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItokenServicePostsApplication.class, args);
    }
}
