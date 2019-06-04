package com.jxy.studycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@RefreshScope
@EnableEurekaClient
@EnableDiscoveryClient
//@RibbonClient(name = "LICENSINGSERVICE")
public class LicenseConsumerApplication_7003 {
    public static void main(String[] args) {
        SpringApplication.run(LicenseConsumerApplication_7003.class, args);
    }
}
