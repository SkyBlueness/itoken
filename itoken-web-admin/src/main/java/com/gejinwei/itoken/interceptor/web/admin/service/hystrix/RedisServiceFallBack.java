package com.gejinwei.itoken.interceptor.web.admin.service.hystrix;

import com.gejinwei.itoken.interceptor.utils.FallBack;
import com.gejinwei.itoken.interceptor.web.admin.service.RedisService;
import org.springframework.stereotype.Component;

@Component
public class RedisServiceFallBack implements RedisService {

    @Override
    public String put(String key, String value, long s) {
        return FallBack.fallBack();
    }


    @Override
    public String get(String key) {
        return FallBack.fallBack();
    }
}
