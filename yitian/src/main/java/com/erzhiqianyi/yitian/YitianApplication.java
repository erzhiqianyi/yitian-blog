package com.erzhiqianyi.yitian;

import com.erzhiqianyi.yitian.common.advice.ApiResponseWrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;

@SpringBootApplication
public class YitianApplication {

	@Bean
	public ApiResponseWrapper responseWrapper(ServerCodecConfigurer serverCodecConfigurer,
											  RequestedContentTypeResolver requestedContentTypeResolver) {
		return new ApiResponseWrapper(serverCodecConfigurer
				.getWriters(), requestedContentTypeResolver);
	}

	public static void main(String[] args) {
		SpringApplication.run(YitianApplication.class, args);
	}

}
