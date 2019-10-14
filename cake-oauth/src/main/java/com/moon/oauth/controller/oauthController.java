package com.moon.oauth.controller;

import com.moon.common.model.ResultData;
import com.moon.oauth.feign.SystemService;
import com.moon.systemapi.entity.SysUser;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/info")
public class oauthController {


    @Autowired
//    @Qualifier("redisTokenStore")
    private TokenStore tokenStore;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    SystemService systemService;

    @RequestMapping("/user")
    public ResultData user(Principal user) {
        SysUser sysUser = systemService.getUserByName(user.getName());
        List roles = new ArrayList();
        roles.add("admin");
        sysUser.setAuthorities(roles);
        redisTemplate.opsForValue().set(user.getName(),sysUser);

        return new ResultData(200, sysUser);
    }

    @RequestMapping("/oauth/remove_token")
    public ResultData removeToken(@RequestParam("token") String token) {

        if (token != null) {
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
            tokenStore.removeAccessToken(accessToken);
        } else {
            return new ResultData(9999, "token没有乐");
        }

        return new ResultData();

    }


    @RequestMapping("/test")
    public ResultData test() {


        return new ResultData(1,"11111111111");

    }
}
