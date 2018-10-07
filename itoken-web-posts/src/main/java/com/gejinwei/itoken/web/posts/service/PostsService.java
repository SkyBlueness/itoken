package com.gejinwei.itoken.web.posts.service;

import com.gejinwei.itoken.interceptor.utils.BaseResult;
import com.gejinwei.itoken.web.posts.service.fallBack.PostsServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "itoken-service-posts",fallback = PostsServiceFallBack.class)
public interface PostsService {

    @PostMapping("/posts")
    public String save(@RequestParam(required = true) String postJson,@RequestParam(required = true) String optBy);

    @GetMapping("/posts/{postGuid}")
    public String selectOne(@PathVariable(required = true)String postGuid);

    @GetMapping("/post/page/{pageNum}/{pageSize}")
    public String selectAll(@PathVariable(required = true)int pageNum,
                            @PathVariable(required = true)int pageSize,
                            @RequestParam(required = false)String postsJson);
}
