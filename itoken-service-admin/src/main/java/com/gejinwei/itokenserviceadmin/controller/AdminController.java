package com.gejinwei.itokenserviceadmin.controller;

import com.gejinwei.itoken.utils.BaseResult;
import com.gejinwei.itokenserviceadmin.pojo.TbSysUser;
import com.gejinwei.itokenserviceadmin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 注册
     * @param tbSysUser
     * @return
     */
    @GetMapping("/register")
    public BaseResult register(TbSysUser tbSysUser){
        adminService.register(tbSysUser);
        return BaseResult.ok();
    }

    public BaseResult login(String loginCode,String password){
        TbSysUser tbSysUser = adminService.login(loginCode, password);
        BaseResult baseResult = checkLogin(loginCode, password);
        if(baseResult != null){
            return baseResult;
        }

        if (tbSysUser != null){
            //登录成功
            return BaseResult.ok(tbSysUser);
        }else {
            //登录失败
            BaseResult.Error error = new BaseResult.Error("","登录失败");
            List<BaseResult.Error>errors = new ArrayList<>();
            errors.add(error);
            return (BaseResult) BaseResult.notOk(errors);
        }
    }

    /**
     * 检查登录
     * @param loginCode
     * @param password
     * @return
     */
    public BaseResult checkLogin(String loginCode,String password){
        BaseResult baseResult = null;
        List<BaseResult.Error> errors = new ArrayList<>();
        if (StringUtils.isEmpty(loginCode)){

            BaseResult.Error error = new BaseResult.Error();
            error.setFeild("loginCode");
            error.setMessage("用户名不能为空");
            errors.add(error);

        }
        if(StringUtils.isEmpty(password)){
            BaseResult.Error error = new BaseResult.Error();
            error.setFeild("password");
            error.setMessage("密码不能为空");
            errors.add(error);
        }
        return baseResult;
    }

}
