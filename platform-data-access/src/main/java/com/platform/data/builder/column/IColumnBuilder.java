package com.platform.data.builder.column;

import com.platform.data.entity.ColumnConstruction;
import com.platform.data.model.ColumnMeta;

public interface IColumnBuilder {

//    /**
//     * 构建sql语句
//     * @param column 列信息
//     * @return sql语句
//     */
//    String build(ColumnConstruction column);

    /**
     * column sql
     * @param columnMeta column
     * @return sql
     */
    String build(ColumnMeta columnMeta);

}
