package com.moon.gateway.feign;


import com.moon.ops.dto.SysApiLogDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "ops-service")
public interface IOpsClient {

    @RequestMapping(value = "/apiLog/addApiLog",method = RequestMethod.POST)
    void addApiLog(@RequestBody SysApiLogDto sysApiLogDto);
}
