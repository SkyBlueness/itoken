package com.gejinwei.itoken.service.admin.service;

import com.gejinwei.itoken.service.admin.pojo.TbSysUser;

public interface AdminService {
    /**
     * 注册方法
     * @param tbSysUser
     */
    public void register(TbSysUser tbSysUser);

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    public TbSysUser login(String username,String password);
}
