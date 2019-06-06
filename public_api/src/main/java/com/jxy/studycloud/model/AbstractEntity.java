package com.jxy.studycloud.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

/**
 * @Auther: jxy
 * @Date: 2019/3/8 10:07
 * @Description:
 */
@MappedSuperclass
@Data
public class AbstractEntity {
     private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    public Long getId() {
        return id;
    }
}
