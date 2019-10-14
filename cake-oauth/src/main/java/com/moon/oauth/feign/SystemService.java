package com.moon.oauth.feign;

import com.moon.systemapi.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "system-service")
public interface SystemService {
    @RequestMapping(value = "/getUserByName",method = RequestMethod.GET)
    SysUser getUserByName(@RequestParam(value = "name") String name);
}
