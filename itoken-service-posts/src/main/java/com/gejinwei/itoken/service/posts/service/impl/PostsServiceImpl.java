package com.gejinwei.itoken.service.posts.service.impl;

import com.gejinwei.itoken.service.posts.pojo.TbPostsPost;
import com.gejinwei.itoken.service.posts.mapper.TbPostsPostMapper;
import com.gejinwei.itoken.service.posts.service.PostsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(readOnly = true)
public class PostsServiceImpl implements PostsService {

    @Autowired
    private TbPostsPostMapper tbPostsPostMapper;

    @Transactional(readOnly = false)
    @Override
    public int insert(TbPostsPost tbPostsPost, String createBy) {
        tbPostsPost.setCreateDate(new Date());
        tbPostsPost.setStatus("1");
        tbPostsPost.setCreateBy(createBy);
        tbPostsPost.setUpdateBy(createBy);
        tbPostsPost.setUpdateDate(new Date());
        return tbPostsPostMapper.insert(tbPostsPost);
    }

    @Transactional(readOnly = false)
    @Override
    public int delete(long postGuid) {
        return tbPostsPostMapper.deleteByPrimaryKey(postGuid);
    }

    @Transactional(readOnly = false)
    @Override
    public int update(TbPostsPost tbPostsPost,String updataBy) {
        tbPostsPost.setUpdateBy(updataBy);
        tbPostsPost.setUpdateDate(new Date());
        return tbPostsPostMapper.updateByPrimaryKey(tbPostsPost);
    }

    @Transactional(readOnly = true)
    @Override
    public PageInfo<TbPostsPost> selectAll(int pageNum, int pageSize,TbPostsPost tbPostsPost) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TbPostsPost> pageInfo = new PageInfo(tbPostsPostMapper.select(tbPostsPost));
        return pageInfo;
    }

    @Transactional(readOnly = true)
    @Override
    public TbPostsPost selectOne(TbPostsPost tbPostsPost) {
        return tbPostsPostMapper.selectOne(tbPostsPost);
    }

    @Transactional(readOnly = true)
    @Override
    public int count(TbPostsPost tbPostsPost) {
        return tbPostsPostMapper.selectCount(tbPostsPost);
    }
}
