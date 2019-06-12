package com.jxy.studycloud.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-12 10:42
 */
@Component
public class UserContextFilter implements Filter {

  private static final Logger logger = LoggerFactory.getLogger(UserContextFilter.class);

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    logger.info("用户上下文过滤器初始化");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    String correlationId = httpServletRequest.getHeader(UserContext.CORRELATION_ID);
    UserContextHolder.getContext().setCorrelationId(correlationId);
    logger.info("用户上下文过滤器退出，correlationId :{}"+correlationId);
    chain.doFilter(request,response);
  }

  @Override
  public void destroy() {
    logger.info("用户上下文过滤器销毁");
  }
}
