package com.gejinwei.itoken.web.posts.interceptor;

import com.gejinwei.itoken.interceptor.pojo.TbSysUser;
import com.gejinwei.itoken.interceptor.utils.CookieUtil;
import com.gejinwei.itoken.interceptor.utils.MapperUtils;
import com.gejinwei.itoken.web.posts.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WebPostsInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = CookieUtil.getCookieValue(request, "token");
        //token为空肯定没登录,重定向到登录页面
        if (StringUtils.isEmpty(token)){
            response.sendRedirect("http://localhost:8503/login?url=http://localhost:8602");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();
        TbSysUser tbSysUser = (TbSysUser) session.getAttribute("tbSysUser");
        //tbSysUser不为空，已经登录
        if (tbSysUser != null){
            if(modelAndView != null){
                modelAndView.addObject("tbSysUser",tbSysUser);
            }
        }
        //tbSysUser为空
        else{
            String token = CookieUtil.getCookieValue(request, "token");
            if(!StringUtils.isEmpty(token)){
                //获取login
                String login = redisService.get(token);
                if (!StringUtils.isEmpty(login)){
                    //获取tbSysUser
                    String json = redisService.get(login);
                    tbSysUser = MapperUtils.json2pojo(json,TbSysUser.class);
                    if(modelAndView != null){
                        modelAndView.addObject("tbSysUser",tbSysUser);
                    }
                    //将值tbSysUser放到session域中
                    session.setAttribute("tbSysUser",tbSysUser);
                }
            }
            //token为空，重定向到登录页
            else {
                response.sendRedirect("http://localhost:8503/login?url=http://localhost:8601");
            }
        }
     }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
