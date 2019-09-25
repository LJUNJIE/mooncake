package com.moon.reportweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.moon.reportweb.*","com.moon.common.config"})
public class ReportWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportWebApplication.class, args);
    }

}
