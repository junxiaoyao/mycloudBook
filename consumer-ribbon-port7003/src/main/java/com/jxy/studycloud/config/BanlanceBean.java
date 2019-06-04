package com.jxy.studycloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-03 14:28
 */
@Configuration
public class BanlanceBean {

  @Bean
  public IRule iRule() {
    return new RandomRule();
  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
