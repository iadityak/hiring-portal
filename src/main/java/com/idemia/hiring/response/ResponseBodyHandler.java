package com.idemia.hiring.response;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice("com.idemia.hiring.controller")
public class ResponseBodyHandler implements ResponseBodyAdvice<Object> {
	private final Logger log = LoggerFactory.getLogger(ResponseBodyHandler.class);
	@Autowired(required=false)
    HttpServletRequest req;

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		String path=req.getRequestURI();
		return body instanceof ResponseEnvelope || body instanceof LinkedHashMap ? body : new ResponseEnvelope(body,null,path);
	}

	@Override
	public boolean supports(MethodParameter arg0, Class<? extends HttpMessageConverter<?>> arg1) {
		return true;
	}
}
