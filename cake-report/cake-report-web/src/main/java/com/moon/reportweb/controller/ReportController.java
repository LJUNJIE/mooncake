package com.moon.reportweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.moon.common.model.ResultData;
import com.moon.reportapi.dto.ReportDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value="报表接口")
public class ReportController {

    private org.slf4j.Logger log = LoggerFactory.getLogger(ReportController.class);

    @RequestMapping("/getReport")
    @ApiOperation(value="获取报表ID", notes="获取报表ID" ,httpMethod="POST")
    public ResultData getReport(@RequestBody ReportDto reportDto) {
        ResultData resultData = new ResultData();
        try {
            log.info("编号"+reportDto.getReportId()+"报表组装中......");
            Thread.sleep(10000L);
            log.info("编号"+reportDto.getReportId()+"报表组装完成了....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JSONObject json = new JSONObject();
        json.put("reportId",reportDto.getReportId());
        json.put("data",Math.random());
        resultData.setData(json);
        resultData.setCode(0000);
        return resultData;
    }

}
