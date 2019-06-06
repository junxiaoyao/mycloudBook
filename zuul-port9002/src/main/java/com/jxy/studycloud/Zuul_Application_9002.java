package com.jxy.studycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@RefreshScope
@EnableZuulProxy
public class Zuul_Application_9002 {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_Application_9002.class, args);
    }
}
