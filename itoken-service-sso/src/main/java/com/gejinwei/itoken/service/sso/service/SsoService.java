package com.gejinwei.itoken.service.sso.service;

import com.gejinwei.itoken.pojo.TbSysUser;

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
