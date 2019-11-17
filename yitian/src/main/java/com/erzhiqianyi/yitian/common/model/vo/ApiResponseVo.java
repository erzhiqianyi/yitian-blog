package com.erzhiqianyi.yitian.common.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseVo<T> {
    @ApiModelProperty(value = "业务编码")
    private int code;

    @ApiModelProperty(value = "业务信息")
    private String msg;

    @ApiModelProperty(value = "业务结果" )
    private T data;

    public ApiResponseVo() {
    }

    public ApiResponseVo(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ApiResponseVo<T> success(T data) {
        return new ApiResponseVo<>(ResponseCodeEnum.SUCCESS.getCode(), null, data);
    }

    public static ApiResponseVo noData() {
        return new ApiResponseVo(ResponseCodeEnum.NO_DATA.getCode(), "no data", null);
    }

    public static <T> ApiResponseVo<T> badRequest(String msg) {
        return new ApiResponseVo<>(ResponseCodeEnum.BAD_REQUEST.getCode(), msg, null);
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
