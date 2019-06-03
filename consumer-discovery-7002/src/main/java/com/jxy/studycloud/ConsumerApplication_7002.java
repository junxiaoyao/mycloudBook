package com.jxy.studycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ConsumerApplication_7002 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication_7002.class, args);
    }
}
