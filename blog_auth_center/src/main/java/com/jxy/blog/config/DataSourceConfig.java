package com.jxy.blog.config;

import com.alibaba.druid.pool.DruidDataSource;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * @description
 * @author: jxy
 * @create: 2020-04-07 13:17
 */

@Configuration
public class DataSourceConfig {

  //数据库url
  @Value("${spring.datasource.url}")
  private String dbUrl;

  //用户名
  @Value("${spring.datasource.username}")
  private String username;

  //密码
  @Value("${spring.datasource.password}")
  private String password;

  //驱动
  @Value("${spring.datasource.driverClassName}")
  private String driverClassName;

  //初始化链接数量
  @Value("${spring.datasource.initialSize}")
  private int initialSize;

  //池中保持的最小连接数
  @Value("${spring.datasource.minIdle}")
  private int minIdle;

  //最大连接数
  @Value("${spring.datasource.maxActive}")
  private int maxActive;

  //最大等待可以连接时间
  @Value("${spring.datasource.maxWait}")
  private int maxWait;

  @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
  private int timeBetweenEvictionRunsMillis;

  @Value("${spring.datasource.minEvictableIdleTimeMillis}")
  private int minEvictableIdleTimeMillis;

  @Value("${spring.datasource.validationQuery}")
  private String validationQuery;

  @Value("${spring.datasource.testWhileIdle}")
  private boolean testWhileIdle;

  @Value("${spring.datasource.testOnBorrow}")
  private boolean testOnBorrow;

  @Value("${spring.datasource.testOnReturn}")
  private boolean testOnReturn;

  //是否对预处理语句（prepared statement）进行池管理
  @Value("${spring.datasource.poolPreparedStatements}")
  private boolean poolPreparedStatements;

  //同一时间最大分配的预处理语句数量
  @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
  private int
      maxPoolPreparedStatementPerConnectionSize;

  @Value("${spring.datasource.filters}")
  private String filters;

  @Value("{spring.datasource.connectionProperties}")
  private String connectionProperties;

  //声明其为Bean实例
  @Bean
  public DataSource dataSource() {
    DruidDataSource datasource = new DruidDataSource();
    datasource.setUrl(this.dbUrl);
    datasource.setUsername(username);
    datasource.setPassword(password);
    datasource.setDriverClassName(driverClassName);
    datasource.setInitialSize(initialSize);
    datasource.setMinIdle(minIdle);
    datasource.setMaxActive(maxActive);
    datasource.setMaxWait(maxWait);
    datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
    datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
    datasource.setValidationQuery(validationQuery);
    datasource.setTestWhileIdle(testWhileIdle);
    datasource.setTestOnBorrow(testOnBorrow);
    datasource.setTestOnReturn(testOnReturn);
    datasource.setPoolPreparedStatements(poolPreparedStatements);
    datasource
        .setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
    try {
      datasource.setFilters(filters);
    } catch (SQLException e) {
    }
    datasource.setConnectionProperties(connectionProperties);
    return datasource;
  }

  @Bean
  public TokenStore tokenStore(DataSource dataSource) {
    return new JdbcTokenStore(dataSource);
  }

  @Bean
  public ClientDetailsService jdbcClientDetails(DataSource dataSource) {
    // 基于 JDBC 实现，需要事先在数据库配置客户端信息
    return new JdbcClientDetailsService(dataSource);
  }

}
