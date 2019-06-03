package com.jxy.studycloud.controllers;
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
  @Autowired
  private RestTemplate restTemplate;
  private final static String SERVICE_URL_PREFIX="http://LICENSINGSERVICE";
  @RequestMapping("/getById")
  public Emp getById(Long id){
    HashMap<String,Object> map=new HashMap<>();
    map.put("id",id);
    return restTemplate.getForObject(SERVICE_URL_PREFIX+"/getById",Emp.class,map);
  }
  @RequestMapping("/getLicenseById")
  public License getLicenseById(Long id){
    HashMap<String,Object> map=new HashMap<>();
    map.put("id",id);
    return restTemplate.getForObject(SERVICE_URL_PREFIX+"/getLicenseById",License.class,map);
  }
  @RequestMapping("/getAllEmp")
  public List<Emp> getAllLicense(){
    return restTemplate.getForObject(SERVICE_URL_PREFIX+"/getAllEmp",List.class);
  }
}
