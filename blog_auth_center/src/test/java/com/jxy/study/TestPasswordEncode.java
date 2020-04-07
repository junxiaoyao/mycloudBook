package com.jxy.study;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @description
 * @author: jxy
 * @create: 2020-04-07 13:14
 */
public class TestPasswordEncode {

  public static void main(String[] args) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    System.out.println(bCryptPasswordEncoder.encode("client"));
  }
}
