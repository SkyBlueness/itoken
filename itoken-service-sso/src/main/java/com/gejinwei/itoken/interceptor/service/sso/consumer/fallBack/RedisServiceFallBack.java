package com.gejinwei.itoken.interceptor.service.sso.consumer.fallBack;

import com.gejinwei.itoken.interceptor.service.sso.consumer.RedisService;
import com.gejinwei.itoken.interceptor.utils.FallBack;
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
