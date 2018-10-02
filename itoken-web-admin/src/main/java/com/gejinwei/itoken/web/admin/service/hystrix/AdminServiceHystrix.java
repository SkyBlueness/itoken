package com.gejinwei.itoken.web.admin.service.hystrix;

import com.gejinwei.itoken.utils.BaseResult;
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
        String json = null;
        try {
            json = MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                    new BaseResult.Error("502","从上游服务器接收到无效响应"))));
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
