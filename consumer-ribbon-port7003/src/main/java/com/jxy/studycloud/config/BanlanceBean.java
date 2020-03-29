package com.jxy.studycloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
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

  //指明负载均衡算法
  @Bean
  public IRule iRule() {
    return new RoundRobinRule();
  }

  @Bean
  @LoadBalanced //告诉Spring创建一个支持Ribbon负载均衡的RestTemplate
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
