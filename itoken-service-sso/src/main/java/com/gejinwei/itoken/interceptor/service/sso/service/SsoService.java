package com.gejinwei.itoken.interceptor.service.sso.service;


import com.gejinwei.itoken.interceptor.service.sso.pojo.TbSysUser;

/**
 * sso业务
 */
public interface SsoService {
    /**
     * 登录
     * @param loginCode
     * @param password
     * @return
     */
    public TbSysUser login(String loginCode, String password);
}
