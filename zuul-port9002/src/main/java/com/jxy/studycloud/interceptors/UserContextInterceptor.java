//package com.jxy.studycloud.interceptors;
//
//import com.jxy.studycloud.utils.UserContext;
//import com.jxy.studycloud.utils.UserContextHolder;
//import org.omg.PortableInterceptor.ClientRequestInterceptor;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpRequest;
//import org.springframework.http.client.ClientHttpRequestExecution;
//import org.springframework.http.client.ClientHttpRequestInterceptor;
//import org.springframework.http.client.ClientHttpResponse;
//
//import java.io.IOException;
//
///**
// * @author jxy
// * @className UserContextInterceptor
// * @description 描述
// * @date 2020/3/30 21:14
// */
//public class UserContextInterceptor implements ClientHttpRequestInterceptor {
//    @Override
//    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
//        HttpHeaders headers = request.getHeaders();
//        headers.add(UserContext.CORRELATION_ID, UserContextHolder.getContext().getCorrelationId());
//        headers.add(UserContext.AUTH_TOKEN, UserContextHolder.getContext().getAuthToken());
//
//        return execution.execute(request, body);
//    }
//}
