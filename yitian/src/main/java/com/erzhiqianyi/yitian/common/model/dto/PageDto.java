package com.erzhiqianyi.yitian.common.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageDto<T> {

    private Integer total;

    private List<T> results;

}
