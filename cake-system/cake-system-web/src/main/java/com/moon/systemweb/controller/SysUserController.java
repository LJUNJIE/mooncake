package com.moon.systemweb.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.moon.common.model.ResultData;
import com.moon.systemapi.entity.SysUser;
import com.moon.systemweb.req.PageReq;
import com.moon.systemweb.service.ISysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @RequestMapping("/findUserList")
    @ResponseBody
    @ApiOperation(value="测试用接口", notes="测试用接口" ,httpMethod="POST")
    public ResultData home(@RequestBody PageReq pageReq) {
        Page<SysUser> users = sysUserService.selectPage(new Page<>(1, 10));
        return new ResultData(0,users);
    }
}
