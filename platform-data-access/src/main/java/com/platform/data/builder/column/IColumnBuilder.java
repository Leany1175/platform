package com.platform.data.builder.column;

import com.platform.data.entity.ColumnConstruction;

public interface IColumnBuilder {

    /**
     * 构建sql语句
     * @param column 列信息
     * @return sql语句
     */
    String build(ColumnConstruction column);

}
