package com.erzhiqianyi.yitian.common.handler.exception;

import com.erzhiqianyi.yitian.common.model.vo.ApiResponseVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ConstraintViolationExceptionHandler {
    @ResponseStatus(value = HttpStatus.OK, reason = "数据格式错误")
    @ExceptionHandler(ConstraintViolationException.class)
    public Mono<ApiResponseVo> methodArgumentNotValidException(ConstraintViolationException ex) {
        return Mono.just(ex)
                .map(ConstraintViolationException::getConstraintViolations)
                .map(constraintViolations -> constraintViolations.stream().findFirst().get())
                .map(constraintViolation -> ApiResponseVo.badRequest(constraintViolation.getMessage()));
    }
}
