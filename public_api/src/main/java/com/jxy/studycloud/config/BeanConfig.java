package com.jxy.studycloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description
 * @author: jxy
 * @create: 2019-05-27 14:41
 */
@Configuration
public class BeanConfig {

  //创建RestTemplate实例
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
