package com.moon.systemapi.feign;

import org.springframework.stereotype.Component;

@Component
public class HelloClientFallBack {
    public String sayHello() {
        return "fallBack Hello";
    }
}
