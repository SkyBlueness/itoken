package com.gejinwei.itoken.admin.service.impl;

import com.gejinwei.itoken.admin.service.AdminService;
import com.gejinwei.itoken.interceptor.mapper.TbSysUserMapper;
import com.gejinwei.itoken.interceptor.pojo.TbSysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

@Service
@Transactional(readOnly = true)
public class AdminServiceImpl implements AdminService {

}
