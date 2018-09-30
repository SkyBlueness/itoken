package com.gejinwei.itoken.utils.itoken.service.admin.service.impl;

import com.gejinwei.itoken.utils.itoken.service.admin.mapper.TbSysUserMapper;
import com.gejinwei.itoken.utils.itoken.service.admin.pojo.TbSysUser;
import com.gejinwei.itoken.utils.itoken.service.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

@Service
@Transactional(readOnly = true)
public class AdminServiceImpl implements AdminService {

    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    @Transactional(readOnly = false)
    @Override
    public void register(TbSysUser tbSysUser) {
        tbSysUserMapper.insert(tbSysUser);
    }

    @Override
    public TbSysUser login(String username, String password) {
        Example example = new Example(TbSysUser.class);
        example.createCriteria().andEqualTo("loginCode",username);
        TbSysUser tbSysUser = tbSysUserMapper.selectOneByExample(example);
        if(password.equals(tbSysUser.getPassword())){
            return tbSysUser;
        }
        return null;
    }
}
