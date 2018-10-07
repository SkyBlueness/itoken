package com.gejinwei.itoken.service.posts.mapper;

import com.gejinwei.itoken.interceptor.utils.RedisCache;
import com.gejinwei.itoken.service.posts.pojo.TbPostsPost;
import com.gejinwei.itoken.service.posts.utils.MyMapper;
import org.apache.ibatis.annotations.CacheNamespace;

@CacheNamespace(implementation = RedisCache.class)
public interface TbPostsPostMapper extends MyMapper<TbPostsPost> {
}