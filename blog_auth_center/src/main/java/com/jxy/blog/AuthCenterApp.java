package com.jxy.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author jxy
 * @className AuthCenterApp
 * @description 描述
 * @date 2020/4/4 20:43
 */
@SpringBootApplication
@EnableResourceServer
public class AuthCenterApp {
    public static void main(String[] args) {
        SpringApplication.run(AuthCenterApp.class, args);
    }
}
