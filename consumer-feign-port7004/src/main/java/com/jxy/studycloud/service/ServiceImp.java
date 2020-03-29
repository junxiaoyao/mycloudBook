package com.jxy.studycloud.service;

import com.jxy.studycloud.model.Emp;
import com.jxy.studycloud.model.License;
import feign.hystrix.FallbackFactory;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-04 16:08
 */
@Component
public class ServiceImp implements FallbackFactory<ServiceInterface> {

    @Override
    public ServiceInterface create(Throwable throwable) {
        return new ServiceInterface() {
            @Override
            public Emp getById(Long id) {
                Emp emp = new Emp();
                emp.setName("i am feign fallback create");
                return emp;
            }

            @Override
            public License getLicenseById(Long id) {
                return null;
            }

            @Override
            public List<Emp> getAllLicense() {
                return null;
            }
        };
    }
}
