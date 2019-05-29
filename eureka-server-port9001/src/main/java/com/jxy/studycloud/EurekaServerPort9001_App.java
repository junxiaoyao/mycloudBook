package com.jxy.studycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description
 * @author: jxy
 * @create: 2019-05-29 15:03
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerPort9001_App {

  public static void main(String[] args) {
    SpringApplication.run(EurekaServerPort9001_App.class,args);
  }
}
