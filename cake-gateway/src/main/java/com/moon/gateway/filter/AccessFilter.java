package com.moon.gateway.filter;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.moon.gateway.feign.IOpsClient;
import com.moon.ops.dto.SysApiLogDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 网关拦截器，统一管理各模块token验证
 * 通过redis
 *
 */
@Component
public class AccessFilter implements GlobalFilter ,Ordered{

    // url匹配器
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Resource
    private RedisTemplate<String, Object> redisTemplate ;
    @Autowired
    private IOpsClient opsClient;

    @Override
    public int getOrder() {
    // TODO Auto-generated method stub
        return -500;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    // TODO Auto-generated method stub

        String accessToken = extractToken(exchange.getRequest());

        if(pathMatcher.match("/**/v2/api-docs/**",exchange.getRequest().getPath().value())){
            return chain.filter(exchange);
        }

        if(!pathMatcher.match("/api-auth/**",exchange.getRequest().getPath().value())){
            if (accessToken == null) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
            }else{
                try {
                    addApiLog(exchange);
                    if(!redisTemplate.hasKey("pwl_access:" + accessToken)){
                        ServerHttpResponse response = exchange.getResponse();
                        JSONObject message = new JSONObject();
                        message.put("status", -1);
                        message.put("data", "鉴权失败");
                        byte[] bits = message.toJSONString().getBytes(StandardCharsets.UTF_8);
                        DataBuffer buffer = response.bufferFactory().wrap(bits);
                        response.setStatusCode(HttpStatus.UNAUTHORIZED);
                        //指定编码，否则在浏览器中会中文乱码
                        response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
                        return response.writeWith(Mono.just(buffer));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
            }
        }
        return chain.filter(exchange);
    }

    protected String extractToken(ServerHttpRequest request) {
        List<String> strings = request.getHeaders().get("Authorization");
        String authToken = null;
        if (strings != null) {
            authToken = strings.get(0).substring("Bearer".length()).trim();
        }

        if (StringUtils.isBlank(authToken)) {
            strings = request.getQueryParams().get("access_token");
            if (strings != null) {
                authToken = strings.get(0);
            }
        }

        return authToken;
    }

    void addApiLog(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        SysApiLogDto sysApiLog = new SysApiLogDto();
        sysApiLog.setEnv("dev");
        sysApiLog.setRequestUri(exchange.getRequest().getURI().getPath());
        sysApiLog.setMethod(request.getMethodValue());
        sysApiLog.setParams(request.getQueryParams().toString());
        sysApiLog.setCreateTime(new Date());
        sysApiLog.setRemoteIp(request.getHeaders().getHost().getHostName());
        opsClient.addApiLog(sysApiLog);
    }
}