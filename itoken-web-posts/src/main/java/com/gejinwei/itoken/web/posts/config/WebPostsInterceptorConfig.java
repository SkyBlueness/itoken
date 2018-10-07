package com.gejinwei.itoken.web.posts.config;

import com.gejinwei.itoken.web.posts.interceptor.WebPostsInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebPostsInterceptorConfig implements WebMvcConfigurer {

    @Bean
    WebPostsInterceptor webAdminInterceptor(){
        return new WebPostsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webAdminInterceptor()).addPathPatterns("/**").excludePathPatterns("/static");
    }
}
