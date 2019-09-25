package com.moon.systemweb.controller;

import com.moon.common.model.ResultData;
import com.moon.reportapi.dto.ReportDto;
import com.moon.systemapi.entity.User;
import com.moon.systemweb.service.feign.ReportRemoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="远程调用Controller")
public class FeignController {

    @Autowired
    ReportRemoteService reportRemoteService;

    @RequestMapping("/getUserByName")
    @ResponseBody
    @ApiOperation(value="测试用接口", notes="测试用接口" ,httpMethod="POST")
    public User home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        User user = new User();
        user.setUserName("aabb");
        user.setPassword("123456");
        return user;
    }

    /**
     *
     * @param reportId
     * @return
     */
    @GetMapping(value = "/getReport")
    @ResponseBody
    public ResultData getReport(@RequestParam String reportId) {
        ReportDto reportDto = new ReportDto();
        reportDto.setReportId(reportId);
        ResultData resultData = reportRemoteService.getReport(reportDto);
        return resultData;
    }


}
