package com.erzhiqianyi.yitian.common.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ApiModel
@ToString()
public class PaginationRequest {

    @ApiModelProperty(value = "每页数量")
    protected Integer size;

    @ApiModelProperty(value = "当前页")
    protected Integer page;

    @ApiModelProperty(value = "排序字段")
    protected String sortField;

    @ApiModelProperty(value = "排序方式")
    protected String sortOrder;


}
