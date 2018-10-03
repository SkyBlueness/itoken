package com.gejinwei.itoken.service.sso.consumer.fallBack;

import com.gejinwei.itoken.service.sso.consumer.RedisService;
import com.gejinwei.itoken.utils.FallBack;
import com.netflix.ribbon.proxy.annotation.Hystrix;
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
