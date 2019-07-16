package com.erzhiqianyi.blog.handler;

import com.erzhiqianyi.blog.model.vo.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ConstraintViolationExceptionHandler {
    @ResponseStatus(value = HttpStatus.OK, reason = "Resource not found")
    @ExceptionHandler(ConstraintViolationException.class)
    public Mono<ResponseResult> methodArgumentNotValidException(ConstraintViolationException ex) {
        return Mono.just(ex)
                .map(ConstraintViolationException::getConstraintViolations)
                .map(constraintViolations -> constraintViolations.stream().findFirst().get())
                .map(constraintViolation -> ResponseResult.badRequest(constraintViolation.getMessage()));
    }
}
