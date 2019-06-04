package com.jxy.studycloud.controllers;

import com.jxy.studycloud.service.ServiceInterface;
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
@RequestMapping("rest")
public class ConsumerRestController {
  @Autowired
  private ServiceInterface serviceInterface;

  @RequestMapping("/getById")
  public Emp getById(Long id) {
    return serviceInterface.getById(id);
  }

  @RequestMapping("/getLicenseById")
  public License getLicenseById(Long id) {
    return serviceInterface.getLicenseById(id);
  }

  @RequestMapping("/getAllEmp")
  public List<Emp> getAllLicense() {
    return serviceInterface.getAllLicense();
  }
}
