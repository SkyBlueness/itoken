package com.gejinwei.itoken.service.posts.service;

import com.gejinwei.itoken.service.posts.pojo.TbPostsPost;
import com.github.pagehelper.PageInfo;

public interface PostsService {
    //插入文章
    int insert(TbPostsPost tbPostsPost,String createBy);
    //删除文章
    int delete(long postGuid);
    //修改文章
    int update(TbPostsPost tbPostsPost,String updataBy);
    //分页查询文章
    PageInfo selectAll(int pageNum, int pageSize,TbPostsPost tbPostsPost);
    //查询单个文章
    TbPostsPost selectOne(TbPostsPost tbPostsPost);
    //查询总记录数
    int count(TbPostsPost tbPostsPost);
}
