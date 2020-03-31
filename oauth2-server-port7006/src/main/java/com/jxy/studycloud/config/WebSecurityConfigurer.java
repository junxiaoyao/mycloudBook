package com.jxy.studycloud.config;

import com.jxy.studycloud.security.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Auther: jxy
 * @Date: 2019/6/27 20:58
 * @Description:
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService userDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }
    @Override
    @Bean
    public AuthenticationManager authenticationManager()throws Exception{
        return super.authenticationManager();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        web.ignoring("/oauth/**");
       // web.ignoring().anyRequest();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.requestMatchers().anyRequest()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/oauth/**").permitAll();
        http.authorizeRequests().antMatchers("/oauth/**").permitAll();
    }
}
