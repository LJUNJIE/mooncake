package com.moon.systemweb.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.moon.common.model.ResultData;
import com.moon.systemapi.entity.SysUser;
import com.moon.systemweb.req.PageReq;
import com.moon.systemweb.service.ISysUserService;
import com.moon.systemweb.service.feign.AuthService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xjl
 * @since 2019-09-25
 */
@Controller
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    ISysUserService sysUserService;
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    @Autowired
    AuthService authService;

    @RequestMapping("/userPage")
    @ResponseBody
    @ApiOperation(value="userPage", notes="用户页面" ,httpMethod="POST")
    public ResultData findUserList(@RequestBody PageReq pageReq) {
        Page<SysUser> users = sysUserService.selectPage(new Page<>(1, 10));
        return new ResultData(0,users);
    }

    @RequestMapping("/addUser")
    @ResponseBody
    @ApiOperation(value="addUser", notes="新增用户" ,httpMethod="POST")
    public ResultData addUser(@RequestBody SysUser sysUser) {
        sysUserService.insert(sysUser);
        return new ResultData(0,"新增成功");
    }


    @RequestMapping("/delUser")
    @ResponseBody
    @ApiOperation(value="delUser", notes="删除用户" ,httpMethod="POST")
    public ResultData delUser(@RequestBody SysUser sysUser) {
        sysUserService.deleteById(sysUser.getId());
        return new ResultData(0,"删除成功");
    }


    @RequestMapping("/editUser")
    @ResponseBody
    @ApiOperation(value="editUser", notes="修改用户" ,httpMethod="POST")
    public ResultData editUser(@RequestBody SysUser sysUser) {
        sysUserService.updateAllColumnById(sysUser);
        return new ResultData(0,"修改成功");
    }

    @RequestMapping("/userInfo")
    @ResponseBody
    @ApiOperation(value="/userInfo", notes="用户信息" ,httpMethod="POST")
    public ResultData userInfo(@RequestBody SysUser sysUser) {
        if (null != sysUser.getToken()) {
//            String aaa = (String) redisTemplate.opsForValue().get("pwl_access:"+sysUser.getToken());
            String aaa = authService.getName();
            System.out.println(aaa);
        }
        SysUser user = sysUserService.selectById(sysUser);
        return new ResultData(0,user);
    }


    @RequestMapping("/test")
    @ResponseBody
    @ApiOperation(value="/test", notes="用户信息" ,httpMethod="POST")
    public ResultData test() {
        return new ResultData(0,"11111111111");
    }
}
