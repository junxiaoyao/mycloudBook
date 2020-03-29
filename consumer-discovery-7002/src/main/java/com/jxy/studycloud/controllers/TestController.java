package com.jxy.studycloud.controllers;
import com.jxy.studycloud.config.ConsumerDiscoveryClient;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jxy.studycloud.model.*;
import org.springframework.web.client.RestTemplate;

/**
 * @description
 * @author: jxy
 * @create: 2019-05-28 15:59
 */
@RestController
@RequestMapping("test")
public class TestController {
  //注意必须new，否则会被ribbon拦截器拦截，改变URL行为
  private RestTemplate restTemplate=new RestTemplate();
  @Autowired
  private ConsumerDiscoveryClient consumerDiscoveryClient;
  @RequestMapping("/getAllEmp")
  public List<Emp> getAllLicense(){
    String url=consumerDiscoveryClient.getUrl("%s/test/getAllEmp");
    return restTemplate.getForObject(url,List.class);
  }
}
