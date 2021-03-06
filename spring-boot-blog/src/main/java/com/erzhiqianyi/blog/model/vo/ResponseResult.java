package com.erzhiqianyi.blog.model.vo;

import com.erzhiqianyi.blog.swagger.SwaggerConstant;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.log4j.Log4j2;

@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
@Log4j2
public class ResponseResult<T> {

    @ApiModelProperty(value = SwaggerConstant.PROPERTY_RESULT_CODE)
    private int code;

    @ApiModelProperty(value = SwaggerConstant.PROPERTY_RESULT_MSG)
    private String msg;

    @ApiModelProperty(value = SwaggerConstant.PROPERTY_RESULT_DATA)
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult(0, null, data);
    }

    public static ResponseResult noData() {
        return new ResponseResult<>(20000, "no data", null);
    }

    public static <T> ResponseResult<T> badRequest(String msg) {
        return new ResponseResult<>(400, msg, null);
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
