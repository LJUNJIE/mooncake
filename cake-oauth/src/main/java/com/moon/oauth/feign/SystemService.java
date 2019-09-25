package com.moon.oauth.feign;

import com.moon.systemapi.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-system")
public interface SystemService {
    @RequestMapping(value = "/getUserByName",method = RequestMethod.GET)
    User getUserByName(@RequestParam(value = "name") String name);
}
