package com.jxy.studycloud.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * @description
 * @author: jxy
 * @create: 2019-05-28 16:53
 */
@Table(name = "emp")
@Data
@Entity
public class Emp extends AbstractEntity {
  private String name;
  private String sex;
}
