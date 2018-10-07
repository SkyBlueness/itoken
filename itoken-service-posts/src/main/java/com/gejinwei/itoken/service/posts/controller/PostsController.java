package com.gejinwei.itoken.service.posts.controller;

import com.gejinwei.itoken.interceptor.utils.BaseResult;
import com.gejinwei.itoken.interceptor.utils.MapperUtils;
import com.gejinwei.itoken.service.posts.pojo.TbPostsPost;
import com.gejinwei.itoken.service.posts.service.PostsService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    /**
     * 根据主键查询文章
     */
    @GetMapping("{postGuid}")
    public BaseResult selectOne(@PathVariable(required = true) String postGuid){
        TbPostsPost tbPostsPost = new TbPostsPost();
        tbPostsPost.setPostGuid(postGuid);
        TbPostsPost obj = postsService.selectOne(tbPostsPost);
        return BaseResult.ok(obj);
    }
    /**
     * 操作文章
     */
    @PostMapping()
    public BaseResult save(@RequestParam(required = true) String postsJson,
                           @RequestParam(required = true) String optBy){
        int result = 0;
        TbPostsPost tbPostsPost = null;
        try {
            tbPostsPost = MapperUtils.json2pojo(postsJson, TbPostsPost.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (tbPostsPost != null){
            if(tbPostsPost.getPostGuid() == null){
                //主键为空,表示新增
                result = postsService.insert(tbPostsPost,optBy);
                if (result>0){
                    return BaseResult.ok("新增文章成功");
                }

            }else {
                //不为空，表示修改
                result = postsService.update(tbPostsPost, optBy);
                if (result>0){
                    return BaseResult.ok("保存文章成功");
                }
            }

        }

        return BaseResult.ok("操作文章失败");
    }

    /**
     * 分页查询文章
     */
    @GetMapping("/page/{pageNum}/{pageSize}")
    public BaseResult selectAll(@PathVariable(required = true) int pageNum,
                                @PathVariable(required = true) int pageSize,
                                @RequestParam(required = false) String postsJson){
        TbPostsPost tbPostsPost = null;
        if (!StringUtils.isEmpty(postsJson)){
            try {
                tbPostsPost = MapperUtils.json2pojo(postsJson, TbPostsPost.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        PageInfo pageInfo = postsService.selectAll(pageNum, pageSize, tbPostsPost);
        //分页的结果集
        List<TbPostsPost> list = pageInfo.getList();
        BaseResult.Cursor cursor = new BaseResult.Cursor();
        cursor.setTotle(new Long(pageInfo.getTotal()).intValue());
        cursor.setLimit(pageInfo.getSize());
        cursor.setOffset(pageInfo.getPageNum());
        return BaseResult.ok(list,cursor);
    }
}
