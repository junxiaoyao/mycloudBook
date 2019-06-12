package com.jxy.studycloud.utils;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-12 11:15
 */
public class UserContextInterceptor implements ClientHttpRequestInterceptor {

  @Override
  public ClientHttpResponse intercept(HttpRequest request, byte[] body,
      ClientHttpRequestExecution execution) throws IOException {
    HttpHeaders httpHeaders = request.getHeaders();
    httpHeaders.add(UserContext.CORRELATION_ID, UserContextHolder.getContext().getCorrelationId());
    return execution.execute(request, body);
  }
}
