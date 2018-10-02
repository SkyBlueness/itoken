package com.gejinwei.itoken.service.redis.controller;

import com.gejinwei.itoken.service.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;


    @PostMapping("/put")
    public String put(String key,String value,Long seconds){
        redisService.put(key,value,seconds);
        return "ok";
    }

    @GetMapping("/get")
    public String get(String key){
        Object o = redisService.get(key);
        if (o != null){
            return String.valueOf(o);
        }
        return "not_ok";
    }
}
