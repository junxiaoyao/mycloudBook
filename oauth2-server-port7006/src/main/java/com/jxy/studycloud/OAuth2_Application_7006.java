package com.jxy.studycloud;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
        import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableAuthorizationServer
public class OAuth2_Application_7006 {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2_Application_7006.class, args);
    }
}
