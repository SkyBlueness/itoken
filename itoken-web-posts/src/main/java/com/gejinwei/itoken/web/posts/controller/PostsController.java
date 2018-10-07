package com.gejinwei.itoken.web.posts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostsController {

    /**
     * 跳转到默认页
     */
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
