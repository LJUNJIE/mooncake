package com.moon.oauth.controller;

import com.github.pagehelper.util.StringUtil;
import com.moon.common.model.ResultData;
import com.moon.oauth.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {
    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 登录认证
     * @param username 用户名
     * @param password 密码
     */
    @GetMapping("/login")
    public ResultData login(@RequestParam String username, @RequestParam String password) {
        if("admin".equals(username) && "admin".equals(password)){
            //生成token
            String token = JWTUtil.generateToken(username);

            //生成refreshToken
            // String refreshToken = StringUtil.getUUIDString();
            String refreshToken =token;
            //数据放入redis
            redisTemplate.opsForHash().put(refreshToken, "token", token);
            redisTemplate.opsForHash().put(refreshToken, "username", username);

            //设置token的过期时间
            redisTemplate.expire(refreshToken, JWTUtil.REFRESH_TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);

            return new ResultData(0, token);
        }else{
            return new ResultData(1001, "username or password error");
        }
    }

    /**
     * 刷新token
     */
    @GetMapping("/refreshToken")
    public ResultData refreshToken(@RequestParam String refreshToken) {
        String username = (String)redisTemplate.opsForHash().get(refreshToken, "username");
        if(StringUtil.isEmpty(username)){
            return new ResultData(1003, "refreshToken error");
        }

        //生成新的token
        String newToken = JWTUtil.generateToken(username);
        redisTemplate.opsForHash().put(refreshToken, "token", newToken);
        return new ResultData(0, newToken);
    }


}