package com.moon.systemweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.moon.systemweb.mapper")
@ComponentScan({"com.moon.systemweb.*","com.moon.common.config"})
public class SystemWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemWebApplication.class, args);
    }

}
