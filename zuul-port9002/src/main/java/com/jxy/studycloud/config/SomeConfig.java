package com.jxy.studycloud.config;

import com.jxy.studycloud.utils.UserContextInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * @author jxy
 * @className SomeConfig
 * @description 描述
 * @date 2020/3/30 21:20
 */
@Configuration
public class SomeConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate template = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();
        if (interceptors != null) {
            interceptors.add(new UserContextInterceptor());
            template.setInterceptors(interceptors);
        } else {
            template.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
        }
        return template;
    }
}
