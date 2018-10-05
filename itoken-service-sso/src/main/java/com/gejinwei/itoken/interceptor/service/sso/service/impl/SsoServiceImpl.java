package com.gejinwei.itoken.interceptor.service.sso.service.impl;

import com.gejinwei.itoken.interceptor.mapper.TbSysUserMapper;
import com.gejinwei.itoken.interceptor.pojo.TbSysUser;
import com.gejinwei.itoken.interceptor.service.sso.consumer.RedisService;
import com.gejinwei.itoken.interceptor.service.sso.service.SsoService;
import com.gejinwei.itoken.interceptor.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class SsoServiceImpl implements SsoService {

    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    @Autowired
    private RedisService redisService;

    public TbSysUser login(String loginCode, String password) {
        String user = redisService.get(loginCode);
        //缓存中没数据
        if(user == null){
            Example example = new Example(TbSysUser.class);
            example.createCriteria().andEqualTo("loginCode",loginCode);
            TbSysUser tbSysUser = tbSysUserMapper.selectOneByExample(example);
            if (tbSysUser != null){
                if(password.equals(tbSysUser.getPassword())){
                    try {
                        redisService.put(loginCode, MapperUtils.obj2json(tbSysUser),60 * 60 * 24);
                        return tbSysUser;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
        //缓存中有数据
        else {
            try {
                TbSysUser tbSysUser = MapperUtils.json2pojo(user,TbSysUser.class);
                return tbSysUser;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
