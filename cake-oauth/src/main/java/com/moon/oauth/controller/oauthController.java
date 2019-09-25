package com.moon.oauth.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class oauthController {


    @RequestMapping("/test")
    @ResponseBody
    @ApiOperation(value="测试用接口", notes="测试用接口" ,httpMethod="POST")
    public String  test() {
       return "aaaa";
    }
}
