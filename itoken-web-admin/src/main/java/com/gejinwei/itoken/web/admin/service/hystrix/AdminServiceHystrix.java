package com.gejinwei.itoken.web.admin.service.hystrix;

import com.gejinwei.itoken.utils.BaseResult;
import com.gejinwei.itoken.utils.FallBack;
import com.gejinwei.itoken.utils.MapperUtils;
import com.gejinwei.itoken.web.admin.service.AdminService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 熔断功能
 */
@Component
public class AdminServiceHystrix implements AdminService {

    @Override
    public String login(String loginCode, String password) {
        return FallBack.fallBack();
    }
}
