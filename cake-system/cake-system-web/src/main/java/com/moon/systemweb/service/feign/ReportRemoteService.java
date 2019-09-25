package com.moon.systemweb.service.feign;

import com.moon.common.model.ResultData;
import com.moon.reportapi.dto.ReportDto;
import com.moon.systemweb.service.fallback.ReportRemoteServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-report",fallback = ReportRemoteServiceHystric.class)
public interface ReportRemoteService {
    @RequestMapping(value = "/getReport",method = RequestMethod.POST)
    ResultData getReport(@RequestBody ReportDto reportDto);
}
