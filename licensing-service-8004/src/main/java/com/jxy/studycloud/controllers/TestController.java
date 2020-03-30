package com.jxy.studycloud.controllers;

import com.jxy.studycloud.config.ServiceConfig;
import com.jxy.studycloud.repository.EmpRepository;
import com.jxy.studycloud.repository.LicenseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  com.jxy.studycloud.services.*;
import com.jxy.studycloud.model.*;
/**
 * @description
 * @author: jxy
 * @create: 2019-05-28 15:59
 */
@RestController
@RequestMapping("test")
public class TestController {
  @Autowired
  private ServiceConfig config;

  @Autowired
  private EmpRepository empRepository;
  @Autowired
  private LicenseRepository licenseRepository;

  @RequestMapping("/info")
  public String getInfo(){
    return config.getExampleProperty();
  }
  @RequestMapping("/getById")
  public Emp getById(Long id){
    Emp emp=new Emp();
    emp.setName("我是一个特殊服务");
    emp.setId(265156L);
    emp.setSex("男");
    return emp;
  }
  @RequestMapping("/getLicenseById")
  public License getLicenseById(Long id){
    return licenseRepository.findOne(id);
  }
  @RequestMapping("/getAllEmp")
  public List<Emp> getAllLicense(){
    return empRepository.findAll();
  }
}
