package com.jxy.studycloud.filters;

import com.jxy.studycloud.model.AbTestingRoute;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-17 12:07
 */
@Component
public class RoutesFilter extends ZuulFilter {

  private static final int FILTR_ORDER = 1;
  private static final boolean SHOULD_FILTER = true;
  @Autowired
  private FilterUtils filterUtils;

  @Override
  public String filterType() {
    return FilterUtils.ROUTE_FILTER_TYPE;
  }

  @Override
  public int filterOrder() {
    return FILTR_ORDER;
  }

  @Override
  public boolean shouldFilter() {
    return SHOULD_FILTER;
  }

  @Override
  public Object run() {
    RequestContext requestContext = RequestContext.getCurrentContext();
    System.out.println(filterUtils.getServiceId());
    return null;
  }


  public boolean useSpecialRoute() {
    int num = (int) (Math.random() * 10);
    return num>5;
  }
}
