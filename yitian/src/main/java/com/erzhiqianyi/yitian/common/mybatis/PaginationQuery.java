package com.erzhiqianyi.yitian.common.mybatis;

import lombok.Data;

@Data
public class PaginationQuery {

    protected Integer size;

    protected Integer page;

    protected String sortField;

    protected SortOrder sortOrder;

}
