package com.karl.apacheshiro.controller;

import com.karl.apacheshiro.common.MyResponse;
import com.karl.apacheshiro.entity.SysUser;
import com.karl.apacheshiro.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Date 2020/4/19 11:36
 * @Created karl xie
 */
@RestController
@RequestMapping("/api/user")
public class SysUserController {
    /** 存储Token的H Headers Key **/
    protected static final String AUTHORIZATION_HEADER = "Authorization";
    @Resource
    SysUserService sysUserService;

    /** 用户登录接口
     * @param sysUser 用户登录的用户名和密码
     * @return 用户Token和角色
     */
    @PostMapping(value = "/login")
    public MyResponse login(@RequestBody final SysUser sysUser, ServletResponse response) {
        MyResponse myResponse = sysUserService.login(sysUser);
        // 如果登录成功
        // 将 Token 写入到 Response 的 Header，方便前端刷新 Token 从 Header 取值
        if ("SUCCESS".equals(myResponse.getStatus())) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.addHeader(AUTHORIZATION_HEADER, myResponse.getMessage());
        }
        return myResponse;
    }

    @PostMapping("/register")
    public MyResponse register(@RequestBody SysUser sysUser) {
        return sysUserService.save(sysUser);
    }

    @GetMapping("/hello")
    public String hello() {
        return "已经登录的用户可见";
    }

    @RequiresRoles("ADMIN")
    @PostMapping("/admin")
    public String admin() {
        return "Admin 的用户角色可以见";
    }

    @RequiresPermissions("update")
    @GetMapping("/permission")
    public String permission() {
        return "需要 update 的权限才能访问";
    }
}