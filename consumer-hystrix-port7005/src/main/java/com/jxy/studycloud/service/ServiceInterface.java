package com.jxy.studycloud.service;

import com.jxy.studycloud.model.Emp;
import com.jxy.studycloud.model.License;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-04 15:22
 */
@FeignClient(value = "LICENSINGSERVICE",fallbackFactory = ServiceImp.class)
public interface ServiceInterface {

  @RequestMapping("/test/getById")
  Emp getById(@RequestParam("id") Long id);

  @RequestMapping("/test/getLicenseById")
  License getLicenseById(@RequestParam("id") Long id);

  @RequestMapping("/test/getAllEmp")
  List<Emp> getAllLicense();
}
