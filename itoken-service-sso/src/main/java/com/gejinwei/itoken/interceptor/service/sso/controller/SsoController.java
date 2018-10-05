package com.gejinwei.itoken.interceptor.service.sso.controller;

import com.gejinwei.itoken.interceptor.pojo.TbSysUser;
import com.gejinwei.itoken.interceptor.service.sso.consumer.RedisService;
import com.gejinwei.itoken.interceptor.service.sso.service.SsoService;
import com.gejinwei.itoken.interceptor.utils.CookieUtil;
import com.gejinwei.itoken.interceptor.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class SsoController {

    @Autowired
    private SsoService ssoService;

    @Autowired
    private RedisService redisService;

    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping("/login")
    public String login(HttpServletRequest request,@RequestParam(required = false) String url){
        String token = CookieUtil.getCookieValue(request, "token");
        //token不为空，可能已经登录
        if(!StringUtils.isEmpty(token)){
            String loginCode = redisService.get(token);
            //login不为空，可能已经登录
            if(!StringUtils.isEmpty(loginCode)){
                String s = redisService.get(loginCode);
                if (!StringUtils.isEmpty(s)){
                    try {
                        TbSysUser tbSysUser = MapperUtils.json2pojo(s, TbSysUser.class);
                        if(tbSysUser != null){
                            if (!StringUtils.isEmpty(url)){
                                return "redirect:" + url;
                            }
                        }
                        //将TbSysUser对象传到前端页面
                        request.setAttribute("tbSysUser",tbSysUser);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (!StringUtils.isEmpty(url)){
            request.setAttribute("url",url);
        }
        return "login";
    }

    /**
     * 登录业务
     * @param loginCode 账号名
     * @param password  密码
     * @param url 子系统登录的地址
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/login")
    public String login(String loginCode, String password, @RequestParam(required = false) String url,
                        HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes){
        TbSysUser tbSysUser = ssoService.login(loginCode, password);

        if(tbSysUser == null){
            redirectAttributes.addFlashAttribute("message","用户名或者密码错误，请重新输入");
        }
        else {
            //生成一个UUID作为sso的令牌存到redis中
            String token = UUID.randomUUID().toString();
            String result = redisService.put(token, loginCode, 60 * 60 * 24);
            if(result.equals("ok")){
                //将token和login存到cookie中作为子系统的识别符
                CookieUtil.setCookie(request,response,"token",token);
                if(! StringUtils.isEmpty(url)){
                    //重定向到子系统页面
                    return "redirect:" + url;
                }
            }
            //熔断处理
            else {
                redirectAttributes.addFlashAttribute("message","服务器异常，请稍后再试");
            }
        }
        //登录失败返回到登录页面
        return "redirect:/login";
    }
}
