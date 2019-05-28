package com.jxy.studycloud.controllers;

import com.jxy.studycloud.config.ServiceConfig;
import com.jxy.studycloud.repository.EmpRepository;
import com.jxy.studycloud.repository.LicenseRepository;
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
    return empRepository.findOne(id);
  }
  @RequestMapping("/getLicenseById")
  public License getLicenseById(Long id){
    return licenseRepository.findOne(id);
  }
//  private LicenseService service;
//  @RequestMapping("/info")
//  public String getInfo(){
//    return config.getExampleProperty();
//  }
//  @RequestMapping("/getById")
//  public License getById(Long id){
//    return licenseRepository.findOne(id);
//  }
}
