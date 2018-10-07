package com.gejinwei.itoken.web.posts.service.fallBack;

import com.gejinwei.itoken.interceptor.utils.FallBack;
import com.gejinwei.itoken.web.posts.service.PostsService;
import org.springframework.stereotype.Component;

@Component
public class PostsServiceFallBack implements PostsService {

    @Override
    public String save(String postJson, String optBy) {
        return FallBack.fallBack();
    }

    @Override
    public String selectOne(String postGuid) {
        return FallBack.fallBack();
    }

    @Override
    public String selectAll(int pageNum, int pageSize, String postsJson) {
        return FallBack.fallBack();
    }
}
