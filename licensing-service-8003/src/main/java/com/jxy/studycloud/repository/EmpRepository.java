package com.jxy.studycloud.repository;

import com.jxy.studycloud.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description
 * @author: jxy
 * @create: 2019-05-28 16:55
 */
public interface EmpRepository extends JpaRepository<Emp,Long> {

}
