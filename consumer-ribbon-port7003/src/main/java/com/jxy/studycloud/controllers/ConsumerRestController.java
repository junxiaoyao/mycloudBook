package com.jxy.studycloud.controllers;

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
    private final static String SERVICE_URL_PREFIX = "http://LICENSINGSERVICE";

    @RequestMapping("/getById")
    public Emp getById(Long id) {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("id", id);
        return restTemplate.postForObject(SERVICE_URL_PREFIX + "/test/getById", paramMap, Emp.class);
    }

    @RequestMapping("/getLicenseById")
    public License getLicenseById(Long id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        return restTemplate
                .getForObject(SERVICE_URL_PREFIX + "/test/getLicenseById?id={id}", License.class, map);
    }

    @RequestMapping("/getLicenseById2")
    public License getLicenseById2(Long id) {

        return restTemplate
                .getForObject(SERVICE_URL_PREFIX + "/test/getLicenseById2/{id}", License.class, id);
    }

    @RequestMapping("/getAllEmp")
    public List<Emp> getAllLicense() {
        return restTemplate.getForObject(SERVICE_URL_PREFIX + "/test/getAllEmp", List.class);
    }
}
