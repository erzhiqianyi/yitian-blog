package com.erzhiqianyi.yitian.common.handler.exception;

import com.erzhiqianyi.yitian.common.model.vo.ApiResponseVo;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class WebExchangeBindExceptionHandler {
    @ResponseStatus(value = HttpStatus.OK, reason = "数据格式错误")
    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<ApiResponseVo> methodArgumentNotValidException(WebExchangeBindException ex) {
        return Mono.just(ex)
                .map(WebExchangeBindException::getBindingResult)
                .map(BindingResult::getFieldError)
                .map(FieldError::getDefaultMessage)
                .map(message -> ApiResponseVo.badRequest(message));
    }
}
