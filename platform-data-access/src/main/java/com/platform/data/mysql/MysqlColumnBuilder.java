package com.platform.data.mysql;

import com.platform.data.builder.column.BaseColumnBuilder;
import com.platform.data.entity.ColumnConstruction;

public class MysqlColumnBuilder extends BaseColumnBuilder {

    @Override
    protected String createIntegerColumn(ColumnConstruction column) {
        return createColumnLength(column);
    }

    @Override
    protected String createTimestampColumn(ColumnConstruction column) {
        StringBuffer buffer = new StringBuffer(column.getColumnName())
                .append(" datetime");
        defaultAndNull(buffer, column);
        return buffer.toString();
    }

}
