package com.gejinwei.itoken.web.admin.service;

import com.gejinwei.itoken.web.admin.service.hystrix.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//fallback绑定熔断功能类
@FeignClient(value = "itoken-service-admin",fallback = AdminServiceHystrix.class)
public interface AdminService {

    @GetMapping("/login")
    public String login(@RequestParam(value = "loginCode") String loginCode,@RequestParam(value = "password") String password) throws Exception;
}
