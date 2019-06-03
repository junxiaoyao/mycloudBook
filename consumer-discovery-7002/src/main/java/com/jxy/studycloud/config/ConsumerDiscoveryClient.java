package com.jxy.studycloud.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-03 15:22
 */
@Component
public class ConsumerDiscoveryClient {

  @Autowired
  private DiscoveryClient discoveryClient;

  public ServiceInstance getServiceInstance() {
    List<ServiceInstance> serviceInstances = discoveryClient.getInstances("licensingservice");
    if (serviceInstances.size() == 0) {
      return null;
    }
    return serviceInstances.get(0);
  }

  public String getUrl(String url) {
    ServiceInstance serviceInstance=this.getServiceInstance();
    if (serviceInstance==null)
      throw new RuntimeException("404 ,NOT FOUND");
    String urlR=String.format(url,serviceInstance.getUri().toString());
    return urlR;
  }
}
