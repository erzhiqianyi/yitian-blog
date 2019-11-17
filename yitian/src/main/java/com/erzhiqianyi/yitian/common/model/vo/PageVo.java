package com.erzhiqianyi.yitian.common.model.vo;


import com.erzhiqianyi.yitian.admin.system.model.dto.SystemConfigDto;
import com.erzhiqianyi.yitian.common.model.dto.PageDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
public class PageVo<T> {

    @ApiModelProperty(value = "总数量")
    private Integer total;

    @ApiModelProperty(value = "分页数据")
    private List<T> results;



    public PageVo(PageDto<T> pageDto) {
        this.total = pageDto.getTotal();
        this.results = pageDto.getResults();
    }
}
