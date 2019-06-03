package com.jxy.studycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RefreshScope
@EnableEurekaClient
@RibbonClient(name = "LICENSINGSERVICE")
public class LicenseConsumerApplication_7001 {
    public static void main(String[] args) {
        SpringApplication.run(LicenseConsumerApplication_7001.class, args);
    }
}
