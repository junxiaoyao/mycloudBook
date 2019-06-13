package com.jxy.studycloud.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description 在调用服务之前执行的过滤器
 * @author: jxy
 * @create: 2019-06-12 10:03
 */
@Component
public class PreFilter extends ZuulFilter {

  private static final int FILTR_ORDER = 1;
  private static final boolean SHOULD_FILTER = true;
  private static final Logger logger = LoggerFactory.getLogger(PreFilter.class);
  @Autowired
  private FilterUtils filterUtils;

  //过滤器类型(前置)
  @Override
  public String filterType() {
    return FilterUtils.PRE_FILTER_TYPE;
  }

  //不同类型过滤器执行顺序
  @Override
  public int filterOrder() {
    return FILTR_ORDER;
  }

  //是否执行过滤
  @Override
  public boolean shouldFilter() {
    return SHOULD_FILTER;
  }

  private boolean isCorrelationIdPresent() {
    if (filterUtils.getCorrelationId() != null) {
      return true;
    }
    return false;
  }

  private String generateCorrelationId() {
    return UUID.randomUUID().toString();
  }

  @Override
  public Object run() {
    if (isCorrelationIdPresent()) {
      logger.info("前置过滤器查询到tmx-correlation-id: {}. ", filterUtils.getCorrelationId());
    }
    else{
      filterUtils.setCorrelationId(generateCorrelationId());
      logger.info("前置过滤器创建tmx-correlation-id : {}.", filterUtils.getCorrelationId());
    }
    RequestContext ctx = RequestContext.getCurrentContext();
    logger.info(String.format("进程即将访问地址: {}.",  ctx.getRequest().getRequestURI()));

    return null;
  }
}
