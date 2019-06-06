package com.jxy.studycloud.controllers;

import com.jxy.studycloud.service.ServiceInterface;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
@RequestMapping("rest")
public class ConsumerRestController {

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private ServiceInterface serviceInterface;
  private final static String SERVICE_URL_PREFIX = "http://LICENSINGSERVICE";

  @RequestMapping("/getById")
  @HystrixCommand(fallbackMethod ="getById2")
  public Emp getById(Long id) {
    return serviceInterface.getById(id);
//    MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
//    paramMap.add("id", id);
//    return restTemplate.postForObject(SERVICE_URL_PREFIX + "/test/getById", paramMap, Emp.class);
  }

  public Emp getById2(Long id) {
    Emp emp = new Emp();
    emp.setName("i am feign HystrixCommand create");
    return emp;
  }

  @RequestMapping("/getLicenseById")
  public License getLicenseById(Long id) {
    HashMap<String, Object> map = new HashMap<>();
    map.put("id", id);
    return restTemplate
        .getForObject(SERVICE_URL_PREFIX + "/test/getLicenseById?id={id}", License.class, map);
  }

  @RequestMapping("/getLicenseById2")
  @HystrixCommand(commandProperties = {
      //execution.isolation.thread.timeoutInMilliseconds
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
  })
  public License getLicenseById2(Long id) {

    return restTemplate
        .getForObject(SERVICE_URL_PREFIX + "/test/getLicenseById2/{id}", License.class, id);
  }

  @RequestMapping("/getLicenseById3")
  @HystrixCommand(fallbackMethod = "getFaillicense")
  public License getLicenseById3(Long id) {
    if ((Math.random() * 3) > 2) {
      throw new RuntimeException("s");
    }
    return restTemplate
        .getForObject(SERVICE_URL_PREFIX + "/test/getLicenseById2/{id}", License.class, id);
  }

  public License getFaillicense(Long id) {
    License license = new License();
    license.setLicenseType("wrong");
    license.setId(id);
    return license;
  }

  @RequestMapping("/getAllEmp")
  public List<Emp> getAllLicense() {
    return restTemplate.getForObject(SERVICE_URL_PREFIX + "/test/getAllEmp", List.class);
  }
}
