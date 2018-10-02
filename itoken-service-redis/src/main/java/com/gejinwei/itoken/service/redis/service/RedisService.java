package com.gejinwei.itoken.service.redis.service;

public interface RedisService {

    /**
     * 添加值
     * @param key
     * @param value
     * @param seconds 执行时间
     */
    public void put(String key,String value,Long seconds);

    /**
     * 取值
     * @param key
     * @return
     */
    public Object get(String key);
}
