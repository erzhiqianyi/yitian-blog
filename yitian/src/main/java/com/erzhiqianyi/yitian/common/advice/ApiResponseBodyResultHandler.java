package com.erzhiqianyi.yitian.common.advice;

import org.springframework.core.MethodParameter;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.HandlerResult;
import org.springframework.web.reactive.HandlerResultHandler;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;
import org.springframework.web.reactive.result.method.annotation.AbstractMessageWriterResultHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

public class ApiResponseBodyResultHandler extends AbstractMessageWriterResultHandler implements HandlerResultHandler {


    protected ApiResponseBodyResultHandler(List<HttpMessageWriter<?>> messageWriters, RequestedContentTypeResolver contentTypeResolver) {
        super(messageWriters, contentTypeResolver);
    }

    /**
     * Constructor with an {@link ReactiveAdapterRegistry} instance.
     *
     * @param writers  writers for serializing to the response body
     * @param resolver to determine the requested content type
     * @param registry for adaptation to reactive types
     */
    public ApiResponseBodyResultHandler(List<HttpMessageWriter<?>> writers,
                                        RequestedContentTypeResolver resolver, ReactiveAdapterRegistry registry) {

        super(writers, resolver, registry);
        setOrder(100);
    }


    /**
     * 是否需要自定义返回结果
     * true则会执行 handlerResult(),false则跳过
     */
    @Override
    public boolean supports(HandlerResult handlerResult) {
        MethodParameter returnType = handlerResult.getReturnTypeSource();
        Class<?> containingClass = returnType.getContainingClass();
        return (AnnotatedElementUtils.hasAnnotation(containingClass, ResponseBody.class) ||
                returnType.hasMethodAnnotation(ResponseBody.class));
    }

    /**
     * 处理返回结果
     */
    @Override
    public Mono<Void> handleResult(ServerWebExchange serverWebExchange, HandlerResult handlerResult) {
        Object body = handlerResult.getReturnValue();
        MethodParameter bodyTypeParameter = handlerResult.getReturnTypeSource();
        return writeBody(body, bodyTypeParameter, serverWebExchange);
    }
}
