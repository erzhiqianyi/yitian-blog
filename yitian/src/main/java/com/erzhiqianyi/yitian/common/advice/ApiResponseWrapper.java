package com.erzhiqianyi.yitian.common.advice;

import com.erzhiqianyi.yitian.common.model.vo.ApiResponseVo;
import org.assertj.core.util.Preconditions;
import org.springframework.core.MethodParameter;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.web.reactive.HandlerResult;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;
import org.springframework.web.reactive.result.method.annotation.ResponseBodyResultHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

public class ApiResponseWrapper extends ResponseBodyResultHandler {
    private static MethodParameter param;

    static {
        try {
            //get new params
            param = new MethodParameter(ApiResponseWrapper.class
                    .getDeclaredMethod("methodForParams"), -1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public ApiResponseWrapper(List<HttpMessageWriter<?>> writers, RequestedContentTypeResolver resolver) {
        super(writers, resolver);
    }

    private static Mono<ApiResponseVo> methodForParams() {
        return null;
    }

    @Override
    public boolean supports(HandlerResult result) {
        //判断返回结果是否已经是 Mono
        boolean isMono = result.getReturnType().resolve() == Mono.class;
        //判断返回结果是否已经是 ResponseResult
        boolean isAlreadyResponse = result.getReturnType().resolveGeneric(0) == ApiResponseVo.class;
        // 已经是Mono<ResponseResult>的结果不用处理，否则统一处理
        return isMono && !isAlreadyResponse;
    }

    //包装返回结果
    @Override
    @SuppressWarnings("unchecked")
    public Mono<Void> handleResult(ServerWebExchange exchange, HandlerResult result) {
        //校验返回结果不能为null
        Preconditions.checkNotNull(result.getReturnValue(), "response is null!");
        // 将结果包装成统一返回结果 ResponseResult
        Mono<ApiResponseVo> body =
                ((Mono<Object>) result
                        .getReturnValue())
                        .map(ApiResponseVo::success)
                        .defaultIfEmpty(ApiResponseVo.noData());
        return writeBody(body, param, exchange);
    }

}
