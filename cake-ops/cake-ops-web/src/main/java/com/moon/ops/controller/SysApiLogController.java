package com.moon.ops.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.moon.common.model.PageReq;
import com.moon.common.model.ResultData;
import com.moon.ops.entity.SysApiLog;
import com.moon.ops.service.ISysApiLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 接口日志表 前端控制器
 * </p>
 *
 * @author xjl
 * @since 2019-10-14
 */
@Controller
@RequestMapping("/apiLog")
public class SysApiLogController {

    @Autowired
    ISysApiLogService sysApiLogService;

    @RequestMapping("/apiLogPage")
    @ResponseBody
    @ApiOperation(value="apiLogPage", notes="API日志页面" ,httpMethod="POST")
    public ResultData apiLogPage(@RequestBody PageReq pageReq) {
        Page<SysApiLog> users = sysApiLogService.selectPage(new Page<>(1, 10));
        return new ResultData(0,users);
    }

    @RequestMapping("/addApiLog")
    @ResponseBody
    @ApiOperation(value="addApiLog", notes="新增API日志" ,httpMethod="POST")
    public ResultData addApiLog(@RequestBody SysApiLog SysApiLog) {
        sysApiLogService.insert(SysApiLog);
        return new ResultData(0,"新增成功");
    }


    @RequestMapping("/delApiLog")
    @ResponseBody
    @ApiOperation(value="delApiLog", notes="删除API日志" ,httpMethod="POST")
    public ResultData delApiLog(@RequestBody SysApiLog SysApiLog) {
        sysApiLogService.deleteById(SysApiLog.getId());
        return new ResultData(0,"删除成功");
    }


    @RequestMapping("/editApiLog")
    @ResponseBody
    @ApiOperation(value="editApiLog", notes="修改API日志" ,httpMethod="POST")
    public ResultData editApiLog(@RequestBody SysApiLog SysApiLog) {
        sysApiLogService.updateAllColumnById(SysApiLog);
        return new ResultData(0,"修改成功");
    }
}
