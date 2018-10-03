package com.gejinwei.itoken.service.sso.controller;

import com.gejinwei.itoken.service.sso.consumer.RedisService;
import com.gejinwei.itoken.service.sso.service.SsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SsoController {

    @Autowired
    private SsoService ssoService;

    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 登录业务
     * @param loginCode
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String login(String loginCode,String password){
        ssoService.login(loginCode,password);
        return "login";
    }

}
