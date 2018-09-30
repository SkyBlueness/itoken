package com.gejinwei.itoken.utils.itoken.service.admin;

import com.gejinwei.itoken.utils.itoken.service.admin.pojo.TbSysUser;
import com.gejinwei.itoken.utils.itoken.service.admin.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItokenServiceAdminApplication.class)
public class ItokenServiceAdminApplicationTests {

    @Autowired
    private AdminService adminService;

    @Test
    public void adminResgister() {
        TbSysUser tbSysUser = new TbSysUser();
        tbSysUser.setUserCode(UUID.randomUUID().toString());
        tbSysUser.setLoginCode("995127604@qq.com");
        tbSysUser.setPassword("123456");
        tbSysUser.setCreateDate(new Date());
        tbSysUser.setUserName("gejinwei");
        tbSysUser.setUserType("0");
        tbSysUser.setMgrType("1");
        tbSysUser.setCreateBy(tbSysUser.getLoginCode());
        tbSysUser.setUpdateBy(tbSysUser.getLoginCode());
        tbSysUser.setUpdateDate(new Date());
        tbSysUser.setCorpCode("0");
        tbSysUser.setCorpName("123");
        tbSysUser.setStatus("0");
        adminService.register(tbSysUser);

    }

}
