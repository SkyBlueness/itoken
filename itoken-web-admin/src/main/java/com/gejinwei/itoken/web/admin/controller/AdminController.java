package com.gejinwei.itoken.web.admin.controller;

import com.gejinwei.itoken.web.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String login() throws Exception {
        String json = adminService.login("", "");
        System.out.println(json);
        return "index";
    }
}
