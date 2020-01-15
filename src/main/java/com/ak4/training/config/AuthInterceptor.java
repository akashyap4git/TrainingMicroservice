package com.ak4.training.config;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthInterceptor implements HandlerInterceptor {
	
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String AUTH_URL = "http://localhost:8071/auth-microservice/authorize";
    
	@Autowired
	private RestTemplate restTemplate;


	private static Logger logger = LoggerFactory.getLogger(AuthInterceptor.class.getName());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean authorized = false;
        String header = request.getHeader(HEADER_STRING);
        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            try {
            	HttpHeaders headers = new HttpHeaders();
            	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            	headers.add(HEADER_STRING, header);
            	HttpEntity<String> entity = new HttpEntity<>(headers);
            	String result = restTemplate.exchange(AUTH_URL, HttpMethod.POST, entity, String.class).getBody();
            	authorized = Boolean.valueOf(result);
            	if(!authorized) {
            		throw new Exception();
            	}
            } catch(Exception e){
                logger.error("Authorization Failed. You are not allowed to access the resource");
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            }
        } else {
            logger.warn("couldn't find bearer string, will ignore the header");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        }
        return authorized;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

	}

}
