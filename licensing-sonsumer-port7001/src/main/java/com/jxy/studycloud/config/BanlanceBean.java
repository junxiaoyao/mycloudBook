package com.jxy.studycloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
