package com.moon.systemweb.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.moon.common.model.ResultData;
import com.moon.systemapi.entity.SysRole;
import com.moon.common.model.PageReq;
import com.moon.systemweb.service.ISysRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author xjl
 * @since 2019-09-26
 */
@Controller
@RequestMapping("/role")
public class SysRoleController {

    @Autowired
    ISysRoleService sysRoleService;

    @RequestMapping("/rolePage")
    @ResponseBody
    @ApiOperation(value="rolePage", notes="角色页面" ,httpMethod="POST")
    public ResultData rolePage(@RequestBody PageReq pageReq) {
        Page<SysRole> users = sysRoleService.selectPage(new Page<>(1, 10));
        return new ResultData(0,users);
    }

    @RequestMapping("/addRole")
    @ResponseBody
    @ApiOperation(value="addRole", notes="新增角色" ,httpMethod="POST")
    public ResultData addRole(@RequestBody SysRole sysRole) {
        sysRoleService.insert(sysRole);
        return new ResultData(0,"新增成功");
    }


    @RequestMapping("/delRole")
    @ResponseBody
    @ApiOperation(value="delRole", notes="删除角色" ,httpMethod="POST")
    public ResultData delRole(@RequestBody SysRole sysRole) {
        sysRoleService.deleteById(sysRole.getId());
        return new ResultData(0,"删除成功");
    }


    @RequestMapping("/editRole")
    @ResponseBody
    @ApiOperation(value="editRole", notes="修改角色" ,httpMethod="POST")
    public ResultData editUser(@RequestBody SysRole sysRole) {
        sysRoleService.updateAllColumnById(sysRole);
        return new ResultData(0,"修改成功");
    }
}
