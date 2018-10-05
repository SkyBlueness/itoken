package com.gejinwei.itoken.interceptor.web.admin.controller;

import com.gejinwei.itoken.interceptor.web.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    /**
     * 跳转登录页
     * @return
     */
    @GetMapping(value = {"","login"})
    public String login(){
        System.out.println("进来了...");
        return "index1";
    }
}
