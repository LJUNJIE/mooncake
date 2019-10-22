package com.moon.systemweb.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.moon.common.model.ResultData;
import com.moon.systemapi.entity.SysMenu;
import com.moon.common.model.PageReq;
import com.moon.systemweb.service.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author xjl
 * @since 2019-09-26
 */
@Controller
@RequestMapping("/menu")
@Api(tags={"menu"})
public class SysMenuController {

    @Autowired
    ISysMenuService sysMenuService;

    @RequestMapping("/menuPage")
    @ResponseBody
    @ApiOperation(value="menuPage", notes="菜单页面" ,httpMethod="POST")
    public ResultData menuPage(@RequestBody PageReq pageReq) {
        Page<SysMenu> menus = sysMenuService.selectPage(new Page<>(1, 10));
        return new ResultData(0,menus);
    }

    @RequestMapping("/addMenu")
    @ResponseBody
    @ApiOperation(value="addMenu", notes="新增菜单" ,httpMethod="POST")
    public ResultData addMenu(@RequestBody SysMenu sysMenu) {
        sysMenuService.insert(sysMenu);
        return new ResultData(0,"新增成功");
    }


    @RequestMapping("/delMenu")
    @ResponseBody
    @ApiOperation(value="delMenu", notes="删除菜单" ,httpMethod="POST")
    public ResultData delMenu(@RequestBody SysMenu sysMenu) {
        sysMenuService.deleteById(sysMenu.getId());
        return new ResultData(0,"删除成功");
    }


    @RequestMapping("/editMenu")
    @ResponseBody
    @ApiOperation(value="editMenu", notes="修改菜单" ,httpMethod="POST")
    public ResultData editUser(@RequestBody SysMenu sysMenu) {
        sysMenuService.updateAllColumnById(sysMenu);
        return new ResultData(0,"修改成功");
    }
}
