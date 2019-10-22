package com.moon.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.moon.product.mapper")
@ComponentScan({"com.moon.product.*","com.moon.common.config"})
public class ProductwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductwebApplication.class, args);
    }

}
