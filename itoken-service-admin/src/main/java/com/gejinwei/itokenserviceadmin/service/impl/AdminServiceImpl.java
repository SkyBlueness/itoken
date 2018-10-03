package com.gejinwei.itokenserviceadmin.service.impl;

import com.gejinwei.itoken.mapper.TbSysUserMapper;
import com.gejinwei.itoken.pojo.TbSysUser;
import com.gejinwei.itokenserviceadmin.service.AdminService;
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
    public void register(TbSysUser tbSysUser) {
        tbSysUserMapper.insert(tbSysUser);
    }


    @Override
    public TbSysUser login(String username, String password) {
        Example example = new Example(TbSysUser.class);
        example.createCriteria().andEqualTo("loginCode",username);
        TbSysUser tbSysUser = tbSysUserMapper.selectOneByExample(example);
        if (tbSysUser != null){
            if(password.equals(tbSysUser.getPassword())){
                return tbSysUser;
            }
        }
        return null;
    }
}
