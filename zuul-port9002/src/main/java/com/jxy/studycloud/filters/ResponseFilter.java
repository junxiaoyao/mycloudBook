package com.jxy.studycloud.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Calendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

/**
 * @description 在调用服务之后执行的过滤器
 * @author: jxy
 * @create: 2019-06-12 15:42
 */
@Component
public class ResponseFilter extends ZuulFilter {

  private static final int FILTR_ORDER = 1;
  private static final boolean SHOULD_FILTER = true;
  private static final Logger logger = LoggerFactory.getLogger(ResponseFilter.class);
  @Autowired
  private FilterUtils filterUtils;

  @Override
  public String filterType() {
    return FilterUtils.POST_FILTER_TYPE;
  }

  @Override
  public int filterOrder() {
    return FILTR_ORDER;
  }

  @Override
  public boolean shouldFilter() {
    return SHOULD_FILTER;
  }

  //将关联id放到response 的header
  @Override
  public Object run() {
    RequestContext requestContext = RequestContext.getCurrentContext();
    logger.info("后置过滤器，获取tmx-correlation-id: {},time: {}" + filterUtils.getCorrelationId(),
        Calendar.getInstance().getTime());
    try {
      InputStream stream = requestContext.getResponseDataStream();
      String body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
      logger.info("后置过滤器，获取结果: {},time: {}" + body,
          Calendar.getInstance().getTime());
    }catch (IOException e){

    }


    requestContext.getResponse()
        .addHeader(FilterUtils.CORRELATION_ID, filterUtils.getCorrelationId());

    return null;
  }
}
