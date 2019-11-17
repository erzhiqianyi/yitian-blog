package com.erzhiqianyi.yitian.common.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class PaginationRequest {

    @ApiModelProperty(value = "每页大小")
    private Integer size;

    @ApiModelProperty(value = "当前页")
    private Integer page;

    private String sortField;

    private String sortOrder;

    public Integer start() {
        if (null == page){
           page = 1;
        }

        if (null == size){
            size = 10;
        }

        return (page - 1) * size;
    }
}
