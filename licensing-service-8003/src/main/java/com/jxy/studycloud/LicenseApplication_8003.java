package com.jxy.studycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@RefreshScope
@EnableEurekaClient
public class LicenseApplication_8003 {
    public static void main(String[] args) {
        SpringApplication.run(LicenseApplication_8003.class, args);
    }
}
