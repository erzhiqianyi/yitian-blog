package com.erzhiqianyi.blog.handler;

import com.erzhiqianyi.blog.model.vo.ResponseResult;
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
    @ResponseStatus(value = HttpStatus.OK, reason = "Resource not found")
    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<ResponseResult> methodArgumentNotValidException(WebExchangeBindException ex) {
        return Mono.just(ex)
                .map(WebExchangeBindException::getBindingResult)
                .map(BindingResult::getFieldError)
                .map(FieldError::getDefaultMessage)
                .map(message -> ResponseResult.badRequest(message));
    }
}
