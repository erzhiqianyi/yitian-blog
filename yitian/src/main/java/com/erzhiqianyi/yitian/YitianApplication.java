package com.erzhiqianyi.yitian;

import com.erzhiqianyi.yitian.common.advice.ApiResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;

import javax.xml.ws.ResponseWrapper;

@SpringBootApplication
public class YitianApplication {

	@Autowired
	private ServerCodecConfigurer serverCodecConfigurer;

	@Autowired
	private RequestedContentTypeResolver requestedContentTypeResolver;

	@Bean
	public ApiResponseWrapper responseWrapper() {
		return new ApiResponseWrapper(serverCodecConfigurer
				.getWriters(), requestedContentTypeResolver);
	}


	public static void main(String[] args) {
		SpringApplication.run(YitianApplication.class, args);
	}

}
