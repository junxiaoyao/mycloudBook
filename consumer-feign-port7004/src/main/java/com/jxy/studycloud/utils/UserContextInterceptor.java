package com.jxy.studycloud.utils;

import java.io.IOException;
import java.util.Calendar;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-12 11:15
 */
@Component
public class UserContextInterceptor implements ClientHttpRequestInterceptor {
  private static final Logger logger = LoggerFactory.getLogger(UserContextInterceptor.class);

  @Override
  public ClientHttpResponse intercept(HttpRequest request, byte[] body,
      ClientHttpRequestExecution execution) throws IOException {
    HttpHeaders httpHeaders = request.getHeaders();
    if (StringUtils.isNotBlank(UserContextHolder.getContext().getCorrelationId())) {
      httpHeaders
          .add(UserContext.CORRELATION_ID, UserContextHolder.getContext().getCorrelationId());
    }
    logger.info("传出服务信息:{},time: {}",UserContextHolder.getContext().getCorrelationId()+ Calendar.getInstance().getTime());
    return execution.execute(request, body);
  }
}
