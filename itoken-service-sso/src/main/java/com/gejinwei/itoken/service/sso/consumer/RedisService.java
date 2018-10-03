package com.gejinwei.itoken.service.sso.consumer;

import com.gejinwei.itoken.service.sso.consumer.fallBack.RedisServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * itoken-service-redis的服务消费者
 */
@FeignClient(value = "itoken-service-redis",fallback = RedisServiceFallBack.class)
public interface RedisService {

    @PostMapping("/put")
    public String put(@RequestParam("key")String key,@RequestParam("value")String value,@RequestParam(value = "seconds")long seconds);

    @GetMapping("/get")
    public String get(@RequestParam("key")String key);
}
