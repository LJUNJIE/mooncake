package com.moon.systemweb.controller;

import com.moon.common.config.RedisServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class RedisController {

    @Autowired
    RedisServer redisServer;

    @GetMapping(value = "/setRedis")
    @ResponseBody
    public String setRedis(@RequestParam String value, @RequestParam String key) {
        redisServer.setValue(key,value);
        return "缓存key:"+key+"对应value:"+value+"保存成功";
    }

    @GetMapping(value = "/getRedis")
    @ResponseBody
    public String getRedis(@RequestParam String key) {
        redisServer.getValue(key);
        return "获取缓存："+redisServer.getValue(key);
    }

}
